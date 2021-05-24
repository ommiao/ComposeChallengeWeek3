package com.example.wetrade.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wetrade.ui.theme.Gray900
import com.example.wetrade.ui.theme.MontFamily
import com.example.wetrade.ui.theme.Purple
import com.example.wetrade.ui.theme.Yellow

@Composable
fun MontText(text: String, modifier: Modifier = Modifier, fontSize: TextUnit = TextUnit.Unspecified, color: Color = Color.Black, fontWeight: FontWeight = FontWeight.Bold, letterSpacing: TextUnit = 0f.sp, textAlign: TextAlign = TextAlign.Center, style: TextStyle = TextStyle()) {
    Text(text = text, color = color, modifier = modifier, fontWeight = fontWeight, fontFamily = MontFamily, letterSpacing = letterSpacing, fontSize = fontSize, textAlign = textAlign, style = style)
}

@Composable
fun ButtonText(text: String, modifier: Modifier = Modifier, fontSize: TextUnit = 13.sp, color: Color = Color.Black) {
    MontText(text = text, fontSize = fontSize, color = color, modifier = modifier, letterSpacing = 1.25.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
}

@Composable
fun WeTradeButton(modifier: Modifier = Modifier, text: String = "BUTTON", bgColor: Color = Yellow, filled: Boolean = true, onClick : () -> Unit = {}){
    Button(
        onClick = onClick,
        modifier = modifier.height(48.dp),
        shape = RoundedCornerShape(24.dp),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp
        ),
        border = if (filled) null else BorderStroke(1.dp, Yellow),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = bgColor,
            contentColor = Color.Transparent
        )
    ) {
        ButtonText(text = text, color = if (filled) Gray900 else Yellow)
    }
}