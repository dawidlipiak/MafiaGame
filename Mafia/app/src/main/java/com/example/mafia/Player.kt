package com.example.mafia

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Player (val nickname: String, val role: Role, var roleVisiability: Boolean = false) {
    var voteCounter : Int = 0

    @Composable
    fun showPlayer() {
        var imageForIcon : Int
        if (nickname.last() == 'a'){
            imageForIcon = R.drawable.woman_icon
        }
        else{
            imageForIcon = R.drawable.man_icon
        }
        Row(modifier = Modifier
            .padding(all = 8.dp)
            .wrapContentWidth(align = Alignment.Start)
        ) {
            Image(
                painter = painterResource(imageForIcon),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = nickname,
                    color = Color.Black,
                    fontSize = 25.sp
                )

                Spacer(modifier = Modifier.height(2.dp))

                if(roleVisiability) {
                    Text(
                        text = role.toString(),
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
            }
        }
    }
}