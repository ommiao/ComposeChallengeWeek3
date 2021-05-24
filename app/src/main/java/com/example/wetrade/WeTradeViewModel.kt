package com.example.wetrade

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class WeTradeViewModel: ViewModel() {

    val types = mutableStateListOf(
        "Week", "ETFs", "Stocks", "Funds", "Others"
    )

}