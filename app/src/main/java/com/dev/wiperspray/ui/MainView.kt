package com.dev.wiperspray.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainView() {

    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp.toFloat()
    val screenWidth = configuration.screenWidthDp.toFloat()

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(Icons.Filled.Close, "close", tint = Color.White)
            Icon(Icons.Filled.Info, "info", tint = Color.White)
        }
        Box(
            modifier = Modifier.fillMaxSize().align(Alignment.BottomCenter),
            ) {
            BoxOne(screenHeight)
        }
    }
}

@Composable
fun BoxOne(screenHeight: Float) {
    Box(
        modifier = Modifier
            .height((screenHeight * 0.8).dp)
            .background(
                color = Color(0xff13181f),
                shape = RoundedCornerShape(
                    topStart = 16.dp,
                    topEnd = 16.dp
                )
            )
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column {
            Text(text = "User, how much you need?", style = TextStyle(color = Color.White, fontSize = 18.sp))
            Text(text = "This is a sample  text", style = TextStyle(color = Color.LightGray, fontSize = 14.sp))
            Spacer(modifier = Modifier.height(28.dp))
            Box(
                modifier = Modifier
                    .height(350.dp)
                    .fillMaxWidth()
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(24.dp)
                    )
                    .align(Alignment.CenterHorizontally)
                    .padding(28.dp)
            ) {
                CircularProgressIndicator(
                    progress = 0.8f,
                    strokeWidth = 8.dp,
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.Center)
                )

                Text(text = "This is a \n sample inside bar",
                    modifier = Modifier.align(Alignment.Center),
                    textAlign = TextAlign.Center,
                    style = TextStyle(color = Color.Gray, fontSize = 14.sp))

                Text(text = "This is a sample text below bar",
                    modifier = Modifier.align(Alignment.BottomCenter),
                    style = TextStyle(color = Color.Gray, fontSize = 14.sp))

            }
        }
    }
}

@Composable
fun BoxTwo(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        Column {
            Text(text = "This is a test", style = TextStyle(color = Color.White))
        }
    }
}

@Composable
fun BoxThree(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        Column {
            Text(text = "This is a test", style = TextStyle(color = Color.White))
        }
    }
}
