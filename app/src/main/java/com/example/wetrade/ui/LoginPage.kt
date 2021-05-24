package com.example.wetrade.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wetrade.R
import com.example.wetrade.ui.theme.White


@Composable
fun LoginPage(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colors.surface)
    ){
        Box(modifier = Modifier.fillMaxWidth()){
            Image(
                painterResource(R.drawable.bg_login),
                contentDescription = "login background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            MontText(
                text = "Welcome\nback",
                style = MaterialTheme.typography.h2,
                color = White,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .paddingFromBaseline(top = 152.dp)
            )
        }
        Column(Modifier.padding(horizontal = 16.dp)) {
            LoginTextField(
                labelText = "Email address",
                labelIcon = Icons.Outlined.Email,
                modifier = Modifier.padding(top = 40.dp)
            )
            LoginTextField(
                labelText = "Password",
                labelIcon = Icons.Outlined.Lock,
                Modifier.padding(vertical = 8.dp)
            )
            WeTradeButton(Modifier.fillMaxWidth().padding(top = 8.dp), text = "LOG IN", onClick = {
                navController.navigate("home")
            })
        }
    }
}

@Composable
private fun LoginTextField(labelText: String, labelIcon: ImageVector, modifier: Modifier = Modifier) {
    OutlinedTextField(
        modifier =
        modifier
            .fillMaxWidth(),
        value = "",
        onValueChange = {},
        label = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    labelIcon,
                    "",
                    modifier = Modifier.size(24.dp),
                    tint = MaterialTheme.colors.onSurface
                )
                MontText(
                    text = labelText,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(horizontal = 8.dp),
                    color = MaterialTheme.colors.onSurface
                )
            }
        }
    )
}