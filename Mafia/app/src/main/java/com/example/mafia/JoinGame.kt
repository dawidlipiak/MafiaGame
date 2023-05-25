package com.example.mafia

import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.End
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mafia.ui.theme.MafiaThemeColor
import com.example.mafia.voting.ui.utils.Utility

@Preview
@Composable
fun JoinGame() {
    var text: TextFieldValue by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.lobby_join),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.poppins_semibold, FontWeight.Bold)),
                fontSize = 25.sp
            ),
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = text,
            placeholder = {
                Text(
                text = "GAME PIN",
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                fontSize = 25.sp,
                textAlign = TextAlign.Center) },

            onValueChange = {
                text = it
            },
            textStyle = TextStyle(
                fontFamily = FontFamily(Font(R.font.poppins_semibold, FontWeight.Bold)),
                fontSize = 25.sp,
                textAlign = TextAlign.Center
            ),
        )

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .padding(top = 100.dp),
            verticalArrangement = Arrangement.Bottom
        ){
            Button(
                onClick = {
                },
                modifier = Modifier
                    .height(60.dp)
                    .width(180.dp),
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MafiaThemeColor,
                    contentColor = colorResource(id = R.color.white),
                )
            ) {
                Text(
                    text = "JOIN",
                    fontSize = 25.sp,
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold))
                )
            }
        }
    }
}