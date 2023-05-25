package com.example.mafia.igor

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mafia.R
import com.example.mafia.ui.theme.MafiaThemeColor

@Composable
fun EntryScreen(navController: NavHostController)
{
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        Image(
            painter = painterResource(id = R.drawable.mafia_icon),
            contentDescription = "Game Logo",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.35f)
                .padding(top = 40.dp),
        )
        Button(
            modifier = Modifier
                .width(190.dp)
                .padding(top = 80.dp, bottom = 10.dp),
            onClick = {
                navController.navigate(Screen.Loading.route)
            },
            shape = RoundedCornerShape(15.dp),
            elevation = ButtonDefaults.buttonElevation(5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MafiaThemeColor
            )
        )
        {
            Text(
                text = "ROZPOCZNIJ GRĘ",
                fontSize = 16.sp
            )
        }
        Button(
            modifier = Modifier
                .width(190.dp)
                .padding(top = 10.dp),
            onClick = {
                navController.navigate(Screen.Loading.route)
            },
            shape = RoundedCornerShape(15.dp),
            elevation = ButtonDefaults.buttonElevation(5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MafiaThemeColor
            )
        )
        {
            Text(
                text = "DOŁĄCZ DO GRY",
                fontSize = 16.sp
            )
        }
    }
}