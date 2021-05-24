package com.example.wetrade.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wetrade.R
import com.example.wetrade.ui.theme.Purple

@Composable
fun WelcomePage(navController: NavController) {
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
            WeTradeButton(Modifier.weight(1f), "GET STARTED")
            Spacer(modifier = Modifier.width(8.dp))
            WeTradeButton(Modifier.weight(1f), "LOG IN", bgColor = Purple, filled = false, onClick = {
                navController.navigate("login")
            })
        }
    }

}