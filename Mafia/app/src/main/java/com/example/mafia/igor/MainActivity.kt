package com.example.mafia.igor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.mafia.ui.theme.MafiaTestTheme

class MainActivity : ComponentActivity() {
    private val variableViewModel: VariableViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MafiaTestTheme {
                variableViewModel.player = Player("Krzysiu", PlayerType.MEDIC)
                Navigation(this, variableViewModel)
            }
        }
    }
}