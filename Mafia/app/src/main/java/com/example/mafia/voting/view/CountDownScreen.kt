package com.example.mafia.voting.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mafia.voting.ui.utils.Utility
import com.example.mafia.voting.ui.utils.Utility.formatTime
import com.example.mafia.voting.view.components.CountDownIndicator
import com.example.mafia.voting.viewmodel.MainViewModel
import com.example.mafia.R
import com.example.mafia.voting.view.components.ReadyButton
import com.example.mafia.voting.view.components.playerVoteWindow

@Composable
fun CountDownView(viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {

    val time by viewModel.time.observeAsState(Utility.TIME_COUNTDOWN.formatTime())
    val progress by viewModel.progress.observeAsState(1.00F)
    val isPlaying by viewModel.isPlaying.observeAsState(false)
    val votable by viewModel.votable.observeAsState(initial = true)
    val voteCount by viewModel.voteCount.observeAsState(initial = 0)

    if(!isPlaying){
        viewModel.handleCountDownTimer()
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CountDownView(time = time, progress = progress, votable = votable){
            viewModel.handleReadyButton()
        }

        Text(
            text = "$voteCount/${Utility.playerList.size}",
            fontSize = 26.sp,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 16.dp)
        )

        playerVoteWindow(players = Utility.playerList, votable){
            viewModel.handleVoting()
        }
    }
}

@Composable
fun CountDownView(
    time: String,
    progress: Float,
    votable: Boolean,
    optionSelected: () -> Unit,
) {
    Column(
        modifier = Modifier.padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "1 minute to vote...",
            color = Color.Black,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            fontFamily = FontFamily(Font(R.font.poppins_semibold))
        )

        CountDownIndicator(
            progress = progress,
            time = time,
            size = 180,
            stroke = 6
        )

        Spacer(modifier = Modifier.height(25.dp))

        ReadyButton(
            modifier = Modifier
                .size(130.dp, 60.dp),
            votable = votable
        ) {
            optionSelected()
        }
    }
}
