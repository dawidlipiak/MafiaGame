package com.example.mafia.igor

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mafia.R

@Composable
fun RoleScreen(navController: NavHostController, context: Context, viewModel: VariableViewModel)
{
    val player = viewModel.player
    val role: String
    val desc: String
    val id: Int
    val color: Color
    if (player != null) {
        when (player.getType()) {
            PlayerType.MAFIA -> {
                role = context.getString(R.string.mafia)
                desc = context.getString(R.string.mafia_desc)
                id = R.drawable.mafia_hat
                color = Color.Gray
            }
            PlayerType.DETECTIVE -> {
                role = context.getString(R.string.detective)
                desc = context.getString(R.string.detective_desc)
                id = R.drawable.detective_glass
                color = Color.Blue
            }
            PlayerType.TOWN_PERSON -> {
                role = context.getString(R.string.civil)
                desc = context.getString(R.string.civil_desc)
                id = R.drawable.town_house
                color = Color.Cyan
            }
            PlayerType.MEDIC -> {
                role = context.getString(R.string.medic)
                desc = context.getString(R.string.medic_desc)
                id = R.drawable.medic_cross
                color = Color.Magenta
            }
        }
        SetRoleScreen(role, desc, id, context, color)
    }
}

@Composable
fun SetRoleScreen(role: String, desc: String, id: Int, context: Context, color: Color)
{
    Box(
        modifier = Modifier
            .background(color)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight(Alignment.CenterVertically),
            verticalArrangement = Arrangement.spacedBy(100.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .wrapContentHeight(Alignment.CenterVertically),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = context.getString(R.string.your_role),
                    fontSize = 36.sp
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = role,
                        fontSize = 28.sp
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(id = id),
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                    )
                }
            }
            Column(
                modifier = Modifier
                    .wrapContentHeight(Alignment.CenterVertically)
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = context.getString(R.string.how_to_play),
                    fontSize = 32.sp
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = desc,
                        fontSize = 23.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}