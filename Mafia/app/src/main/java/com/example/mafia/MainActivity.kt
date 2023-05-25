package com.example.mafia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.material3.Text
import com.example.mafia.voting.ui.utils.Utility
import com.example.mafia.wiktoria.DayWin
import com.example.mafia.wiktoria.NightWin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            DayWin(players = Utility.playerList)
            JoinGame(){

            }
        }
    }
}
