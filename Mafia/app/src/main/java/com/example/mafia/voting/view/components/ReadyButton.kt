package com.example.mafia.voting.view.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mafia.R

@Composable
fun ReadyButton(
    modifier: Modifier = Modifier,
    votable: Boolean,
    optionSelected: () -> Unit
){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var backGroundColor: Int by remember {
            mutableStateOf(R.color.lightBlue)
        }

        Button(
            onClick = {
                optionSelected()
            },
            modifier = Modifier
                .height(70.dp)
                .width(200.dp)
                .weight(1f),

            shape = RoundedCornerShape(25.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = backGroundColor),
                contentColor = colorResource(id = R.color.white),
            ),

            ) {
            backGroundColor = if (votable) {
                R.color.lightBlue
            } else {
                R.color.lightGray
            }

            Text(
                text = "Ready",
                fontSize = 20.sp,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.poppins_semibold))
            )
        }
    }
}