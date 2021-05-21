package com.example.wetrade.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wetrade.R
import com.example.wetrade.ui.theme.Gray900
import com.example.wetrade.ui.theme.Purple
import com.example.wetrade.ui.theme.Yellow

@Preview
@Composable
fun Welcome() {
    Box(Modifier.fillMaxSize()){
        Image(
            painterResource(R.drawable.bg_welcome),
            "Welcome background",
            Modifier
                .fillMaxSize()
                .background(Purple),
            contentScale = ContentScale.Crop
        )
        Image(
            painterResource(R.drawable.ic_logo),
            "WeTrade logo",
            Modifier.align(Alignment.Center)
        )
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(bottom = 32.dp)
                .height(48.dp)
                .align(Alignment.BottomCenter)
        ) {
            Button(
                onClick = {

                },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = Yellow
                )
            ) {
                ButtonText(text = "GET STARTED", color = Gray900)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {

                },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                shape = RoundedCornerShape(24.dp),
                border = BorderStroke(1.dp, Yellow),
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Color.Transparent,
                    backgroundColor = Purple
                )
            ) {
                ButtonText(text = "LOG IN", color = Yellow)
            }
        }
    }

}