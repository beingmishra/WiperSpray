package com.dev.wiperspray.ui

import android.widget.Space
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    var boxOneState by remember { mutableStateOf(false) }
    var boxTwoState by remember { mutableStateOf(true) }
    var boxThreeState by remember { mutableStateOf(true) }

    val boxTwoHeight by animateFloatAsState(
        targetValue = if (boxTwoState) 64f else (screenHeight * 0.7).toFloat(), label = ""
    )

    val boxThreeHeight by animateFloatAsState(
        targetValue = if (boxThreeState) 64f else (screenHeight * 0.5).toFloat(), label = ""
    )

    val showBoxTwo = {
        boxTwoState = false
    }

    val hideBoxTwo = {
        boxTwoState = true
    }

    val showBoxThree = {
        boxThreeState = false
    }

    val hideBoxThree = {
        boxThreeState = true
    }


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
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter),
            ) {
            BoxOne(screenHeight)
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter),
        ) {
            BoxTwo(boxTwoHeight, boxTwoState){
                hideBoxTwo.invoke()
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter),
        ) {
            BoxThree(boxThreeHeight, boxThreeState){
                hideBoxThree.invoke()
            }
        }

        Box(
            modifier = Modifier
                .height(64.dp)
                .fillMaxWidth()
                .background(color = Color.Blue)
                .align(Alignment.BottomCenter)
                .clickable {
                    if (!boxTwoState) {
                        showBoxThree.invoke()
                    } else {
                        showBoxTwo.invoke()
                    }
                } // Handle click event
        ) {
            Text(
                text = if (!boxThreeState) "Tap for 1 click KYC"  else if(!boxTwoState) "Select your bank account" else "Proceed to EMI selection",
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Composable
fun BoxOne(screenHeight: Float) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .height((screenHeight * 0.9).dp)
                .background(
                    color = Color(0xFF1A212B),
                    shape = RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp
                    )
                )
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.BottomCenter)
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
}

@Composable
fun BoxTwo(screenHeight: Float, boxTwoState: Boolean, onClick: () -> Unit) {

    val modifier = if(boxTwoState) Modifier.fillMaxSize() else Modifier
        .fillMaxSize()
        .background(color = Color(0xBF000000))
        .clickable {
            onClick.invoke()
        }

    Box(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .height(screenHeight.dp)
                .background(
                    color = Color(0xFF1A212B),
                    shape = RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp
                    )
                )
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.BottomCenter)
                .clickable { }
        ) {
            Column {
                Text(text = "How do you wish to repay?", style = TextStyle(color = Color.White, fontSize = 18.sp))
                Text(text = "Choose one of our recommended plans or make your own", style = TextStyle(color = Color.LightGray, fontSize = 14.sp))
                Spacer(modifier = Modifier.height(28.dp))

                Row {
                    Box(
                        modifier = Modifier
                            .height(100.dp)
                            .width(100.dp)
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(24.dp)
                            )
                            .padding(28.dp)
                    ) {

                        Text(text = "Card 1",
                            modifier = Modifier.align(Alignment.Center),
                            textAlign = TextAlign.Center,
                            style = TextStyle(color = Color.Gray, fontSize = 14.sp))


                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Box(
                        modifier = Modifier
                            .height(100.dp)
                            .width(100.dp)
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(24.dp)
                            )
                            .padding(28.dp)
                    ) {

                        Text(text = "Card 1",
                            modifier = Modifier.align(Alignment.Center),
                            textAlign = TextAlign.Center,
                            style = TextStyle(color = Color.Gray, fontSize = 14.sp))


                    }
                }

            }
        }
    }
}

@Composable
fun BoxThree(screenHeight: Float, boxTwoState: Boolean, onClick: () -> Unit) {

    val modifier = if(boxTwoState) Modifier.fillMaxSize() else Modifier
        .fillMaxSize()
        .background(color = Color(0xBF000000))
        .clickable {
            onClick.invoke()
        }

    Box(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .height(screenHeight.dp)
                .background(
                    color = Color(0xFF1A212B),
                    shape = RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp
                    )
                )
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.BottomCenter)
                .clickable { }
        ) {
            Column {
                Text(text = "Where should we send the money?", style = TextStyle(color = Color.White, fontSize = 18.sp))
                Text(text = "Amount will be credited to this bank account, EMI will also be debited from this bank account", style = TextStyle(color = Color.LightGray, fontSize = 14.sp))
                Spacer(modifier = Modifier.height(28.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(text = "Paytm Payments Bank", style = TextStyle(color = Color.White, fontSize = 16.sp))
                        Text(text = "919876543210", style = TextStyle(color = Color.LightGray, fontSize = 12.sp))

                    }

                    Checkbox(checked = false, onCheckedChange = {})

                }
            }
        }
    }
}
