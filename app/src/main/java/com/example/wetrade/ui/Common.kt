package com.example.wetrade.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.wetrade.ui.theme.MontFamily

@Composable
fun MontText(text: String, modifier: Modifier = Modifier, fontSize: TextUnit = TextUnit.Unspecified, color: Color = Color.Black, fontWeight: FontWeight = FontWeight.Bold, letterSpacing: TextUnit = 0f.sp, textAlign: TextAlign = TextAlign.Center) {
    Text(text = text, color = color, modifier = modifier, fontWeight = fontWeight, fontFamily = MontFamily, letterSpacing = letterSpacing, fontSize = fontSize, textAlign = textAlign)
}

@Composable
fun ButtonText(text: String, modifier: Modifier = Modifier, fontSize: TextUnit = 13.sp, color: Color = Color.Black) {
    MontText(text = text, fontSize = fontSize, color = color, modifier = modifier, letterSpacing = 1.25.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
}