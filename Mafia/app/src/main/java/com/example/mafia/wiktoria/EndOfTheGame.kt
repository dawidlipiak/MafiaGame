package com.example.mafia


import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest


@Composable
fun DayWin(players : ArrayList<Player>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(R.color.lightYellow))
            .padding(10.dp)
    ) {
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "Miasto wygrało!",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.W700,
            color = Color.Black,
            fontSize = 50.sp,
            modifier = Modifier
                .align(CenterHorizontally)
                .background(Color(R.color.lightYellow)),
        )
        Spacer(modifier = Modifier.height(50.dp))
        GifImage()
        Spacer(modifier = Modifier.height(100.dp))
        Text(
            text = "Miasto tworzyli:",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.W700,
            color = Color.Black,
            fontSize = 25.sp,
            modifier = Modifier
                .align(CenterHorizontally),
        )
        for(i in players) {
            if(i.role == Role.CIVIL || i.role == Role.DOCTOR || i.role == Role.DETECTIVE){
                Text(
                    text = i.nickname + "   " + i.role,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.W700,
                    color = Color.Black,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),

                    )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
fun NightWin(players : ArrayList<Player>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,

        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)

    ) {
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "Mafia wygrała!",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.W700,
            color = Color.Red,
            fontSize = 50.sp,
            modifier = Modifier
                .align(CenterHorizontally),
        )
        Spacer(modifier = Modifier.height(50.dp))
        GifImage()
        Spacer(modifier = Modifier.height(100.dp))
        Text(
            text = "Członkami mafii byli:",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.W700,
            color = Color.Red,
            fontSize = 25.sp,
            modifier = Modifier
                .align(CenterHorizontally),
        )
        Spacer(modifier = Modifier.height(20.dp))

        for(i in players) {
            if(i.role == Role.MAFIA){
                Text(
                    text = i.nickname,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.W700,
                    color = Color.Red,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),

                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }


    }
}

@Composable
fun GifImage(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()
    Image(
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(context).data(data = R.drawable.wingif).apply(block = {

            }).build(), imageLoader = imageLoader
        ),
        contentDescription = null,
        modifier = modifier.fillMaxWidth(),
    )
}
