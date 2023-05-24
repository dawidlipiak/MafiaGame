package com.example.mafia.voting

import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb
import com.example.mafia.voting.view.CountDownView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TransparentStatusBar(windows = window)

            CountDownView()
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
}

