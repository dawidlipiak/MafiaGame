package com.example.mafia.lobby

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mafia.R
import com.example.mafia.voting.ui.utils.Utility

@Composable
fun LobbyScreen(
    startAction: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(10.dp),
        horizontalAlignment = CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.join_lobby),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.poppins_semibold, FontWeight.Bold)),
                fontSize = 25.sp
            ),
        )
        Text(
            text = "2682",
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.poppins_semibold, FontWeight.Bold)),
                fontSize = 40.sp
            ),
        )
        Divider()
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ){
            Column(
                modifier = Modifier
                    .weight(2f),
                horizontalAlignment = Alignment.Start,
            ) {
                Column(horizontalAlignment = CenterHorizontally) {
                    Text(
                        text = "${Utility.playerList.size}",
                        textAlign = TextAlign.Center,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.lightBlue),
                    )
                    Text(
                        text = "Graczy",
                        textAlign = TextAlign.Center,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.lightBlue),
                    )
                }
            }

            Button(
                onClick = {
                    startAction()
                },
                modifier = Modifier
                    .height(50.dp)
                    .width(10.dp)
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.lightBlue),
                    contentColor = colorResource(id = R.color.white),
                )
            ) {
                Text(
                    text = "Start",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold))
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(modifier = Modifier){
            items(Utility.playerList){ player ->
                player.showPlayer()
                Divider()
            }
        }
    }
}
