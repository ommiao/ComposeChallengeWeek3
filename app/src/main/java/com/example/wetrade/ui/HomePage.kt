package com.example.wetrade.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wetrade.BarUtils
import com.example.wetrade.ui.theme.White
import com.example.wetrade.ui.theme.WhiteGray
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Preview
@Composable
fun HomePagePrev() {
    HomePage(navController = rememberNavController())
}

@ExperimentalMaterialApi
@Composable
fun HomePage(navController: NavController) {
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(
            initialValue = BottomSheetValue.Collapsed
        )
    )
    BottomSheetScaffold(
        sheetContent = {
            BottomSheetContent(coroutineScope, bottomSheetScaffoldState)
        },
        sheetPeekHeight = 64.dp,
        sheetShape = RectangleShape,
        scaffoldState = bottomSheetScaffoldState
    ) {
        Column(Modifier.fillMaxWidth()) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .paddingFromBaseline(top = 64.dp, bottom = 8.dp)
            ) {
                ButtonText(text = "ACCOUNT", color = White)
                ButtonText(text = "WATCHLIST", color = WhiteGray)
                ButtonText(text = "PROFILE", color = WhiteGray)
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun BottomSheetContent(coroutineScope: CoroutineScope, bottomSheetScaffoldState: BottomSheetScaffoldState) {
    Column(Modifier.fillMaxSize()) {
        Text(
            text = "Positions", style = MaterialTheme.typography.subtitle1,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .clickable {
                    coroutineScope.launch {
                        if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                            bottomSheetScaffoldState.bottomSheetState.expand()
                        } else {
                            bottomSheetScaffoldState.bottomSheetState.collapse()
                        }
                    }
                }
                .paddingFromBaseline(top = 40.dp, bottom = 24.dp)
                .fillMaxWidth()
        )
    }
}