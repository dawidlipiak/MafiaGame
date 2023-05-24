package com.example.mafia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

class PlayerCardinfo : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = MaterialTheme.colors.background),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    var openDialog by remember {
                        mutableStateOf(false) // Initially dialog is closed
                    }

                    ButtonClick(buttonText = "Open Dialog") {
                        openDialog = true
                    }

                    if (openDialog) {
                        PlayerRoleDialog(Player("Dawid",Role.DETECTIVE)) {
                            openDialog = false
                        }
                    }

                }
            }

        }
    }
}

@Composable
fun PlayerRoleDialog(player: Player, onDismiss: () -> Unit) {
    Dialog(
        onDismissRequest = {
            onDismiss()
        }
    ) {
        Surface(
            elevation = 4.dp,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(30.dp))
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.background(color = player.role.backGroundColor)
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(color = player.role.mainThemeColor),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier
                            .padding(top = 16.dp, bottom = 16.dp),
                        painter = painterResource(id = player.role.logoImage),
                        contentDescription = "Mafia",
                        alignment = Alignment.Center
                    )
                }

                Text(
                    modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
                    text = "${stringResource(id =R.string.your_role)} ${stringResource(id = player.role.whoYouAre)}",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.poppins_semibold, FontWeight.Bold)),
                        fontSize = 20.sp
                    )
                )

                Text(
                    modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                    text = stringResource(id = player.role.description),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.poppins_regular, FontWeight.Normal)),
                        fontSize = 14.sp
                    )
                )

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 36.dp, start = 36.dp, end = 36.dp, bottom = 8.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = player.role.mainThemeColor),
                    onClick = {
                        onDismiss()
                    }) {
                    Text(
                        text = "OK",
                        color = Color.White,
                        style = TextStyle(
                            fontFamily = FontFamily(
                                Font(
                                    R.font.poppins_semibold,
                                    FontWeight.Medium
                                )
                            ),
                            fontSize = 16.sp
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun ButtonClick(
    buttonText: String,
    onButtonClick: () -> Unit
) {
    Button(
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
        onClick = {
            onButtonClick()
        }) {
        Text(
            text = buttonText,
            fontSize = 16.sp,
            color = Color.White
        )
    }
}