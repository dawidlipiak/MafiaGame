package com.example.mafia.igor

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mafia.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController)
{
    var startAnimation by remember {
        mutableStateOf(false)
    }
    val alphaAnimation = animateFloatAsState(
        targetValue = if(startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(Screen.Entry.route)
    }

    Splash(alpha = alphaAnimation.value)
}

@Composable
fun Splash(alpha: Float)
{
    Box(
        modifier = Modifier
            .background(Color.Gray)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        Image(
            painter = painterResource(id = R.drawable.mafia_icon),
            contentDescription = "Game Logo",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(0.85f)
                .alpha(alpha),
        )
    }
}