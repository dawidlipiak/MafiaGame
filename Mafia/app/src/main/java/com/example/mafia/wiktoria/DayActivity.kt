package com.example.mafia.wiktoria

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mafia.R
import com.example.mafia.voting.view.CountDownView

class MainActivityDay : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TransparentStatusBar(windows = window)
            DayActivity()
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
        CountDownView()
//        Text(
//            text = "Nastał dzień",
//            color = Color.Black,
//            fontSize = 25.sp,
//            modifier = Modifier
//                .padding()
//        )
    }

}


@Composable
fun TransparentStatusBar(windows: Window) =
    MaterialTheme {

        windows.statusBarColor = MaterialTheme.colorScheme.surface.toArgb()
        windows.navigationBarColor = MaterialTheme.colorScheme.surface.toArgb()

        @Suppress("DEPRECATION")
        if (MaterialTheme.colorScheme.surface.luminance() > 0.5f) {
            windows.decorView.systemUiVisibility = windows.decorView.systemUiVisibility or
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        @Suppress("DEPRECATION")
        if (MaterialTheme.colorScheme.surface.luminance() > 0.5f) {
            windows.decorView.systemUiVisibility = windows.decorView.systemUiVisibility or
                    View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
        }
    }

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
        DayActivity()
    
}
