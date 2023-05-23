package com.example.mafia.wiktoria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mafia.R

class MainActivityDay : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MafiaTheme {
                
               DayActivity()
             
            }
        }
    }
}
@Composable
//playersList : ArrayList<Player> -trzeba przekazywać funkcji tam
//              |
//              V  
fun DayActivity() {
    val imageModifier = Modifier
        .border(BorderStroke(1.dp,Color.Black))
        .background(Color.Yellow)
    Image(
        painter = painterResource(id = R.drawable.daybackground),
        contentDescription = "Day",
        contentScale = ContentScale.Crop,
        modifier = imageModifier.fillMaxSize()
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()


    ) {
        //CountDownView()
        Text(
            text = "Nastał dzień",
            color = Color.Black,
            fontSize = 25.sp,
            modifier = Modifier
                .padding()
        )
        //playerVoteWindow(players = playersList)

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
        DayActivity()
    
}
