package com.example.mafia.voting.view.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mafia.Player
import com.example.mafia.R

@Composable
fun playerVoteWindow(
    players : ArrayList<Player>,
    votable: Boolean,
    modifier: Modifier = Modifier,
    handleVoting: () -> Unit,
) {
    LazyColumn(modifier.border(3.dp, MaterialTheme.colorScheme.primary)) {
        items(players) {player ->
            var voteCounter : Int by remember {
                mutableStateOf(player.voteCounter)
            }

            Row(modifier = Modifier
                .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                player.showPlayer()
                Spacer(modifier = Modifier.width(30.dp))

                Row(modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(align = Alignment.End)
                ) {
                    if (votable) {
                        Button(
                            onClick = {
                                if (votable) {
                                    voteCounter++
                                    player.voteCounter = voteCounter
                                    handleVoting()
                                }
                            },
                            modifier = Modifier
                                .align(Alignment.CenterVertically),
                            contentPadding = PaddingValues(11.dp,3.dp),
                            shape = RoundedCornerShape(25.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.pink),
                                contentColor = colorResource(id = R.color.white),
                            )
                        ) {
                            Text(
                                text = "VOTE",
                                fontSize = 20.sp,
                                color = Color.White,
                                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                                modifier = Modifier.padding(top = 3.dp)
                            )
                        }
                    }

                    Text(
                        text = voteCounter.toString(),
                        fontSize = 35.sp,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(horizontal = 15.dp)
                            .align(Alignment.CenterVertically)
                    )
                }

            }
            Divider()
        }
    }
}