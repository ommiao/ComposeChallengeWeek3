package com.example.wetrade.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wetrade.R
import com.example.wetrade.WeTradeViewModel
import com.example.wetrade.ui.theme.Green
import com.example.wetrade.ui.theme.White
import com.example.wetrade.ui.theme.WhiteGray
import com.example.wetrade.ui.theme.Yellow
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
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopTextLines()
            MiddleButton()
            MiddleTypesRow()
            Image(
                painterResource(R.drawable.ic_home_illos),
                contentDescription = "illos",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
private fun MiddleTypesRow() {
    val viewModel: WeTradeViewModel = viewModel()
    LazyRow(Modifier.fillMaxWidth()) {
        itemsIndexed(viewModel.types) { index, type ->
            Button(
                modifier = Modifier
                    .height(40.dp)
                    .padding(end = if (index == viewModel.types.size - 1) 16.dp else 8.dp)
                    .padding(start = if (index == 0) 16.dp else 0.dp),
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(1.dp, White),
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = MaterialTheme.colors.background,
                    contentColor = Color.Transparent
                ),
                onClick = {

                }
            ) {
                Text(
                    text = type,
                    style = MaterialTheme.typography.body1,
                    color = White
                )
                if (index == 0) {
                    Icon(
                        painterResource(id = R.drawable.ic_expand_more),
                        "expand more",
                        tint = White,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun MiddleButton() {
    WeTradeButton(
        text = "TRANSACT",
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(bottom = 16.dp)
            .fillMaxWidth()
    )
}

@Composable
private fun TopTextLines() {
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
    Text(
        text = "Balance",
        style = MaterialTheme.typography.subtitle1,
        color = White,
        modifier = Modifier
            .paddingFromBaseline(top = 32.dp, bottom = 8.dp)
    )
    Text(
        text = "$73,589.01",
        style = MaterialTheme.typography.h1,
        color = White,
        modifier = Modifier
            .paddingFromBaseline(top = 48.dp, bottom = 24.dp)
    )
    Text(
        text = "+412.35 today",
        style = MaterialTheme.typography.subtitle1,
        color = Green,
        modifier = Modifier
            .paddingFromBaseline(top = 16.dp, bottom = 32.dp)
    )
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