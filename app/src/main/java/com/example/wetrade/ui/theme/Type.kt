package com.example.wetrade.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(

    body1 = TextStyle(
        fontFamily = MontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 13.sp
    ),

    h1 = TextStyle(
        fontFamily = MontFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 40.sp,
        letterSpacing = 1.25.sp
    ),

    h2 = TextStyle(
        fontFamily = MontFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 36.sp,
        letterSpacing = 0.sp
    ),

    h3 = TextStyle(
        fontFamily = MontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 13.sp,
        letterSpacing = 0.sp
    ),

    subtitle1 = TextStyle(
        fontFamily = MontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        letterSpacing = 0.sp
    )

)