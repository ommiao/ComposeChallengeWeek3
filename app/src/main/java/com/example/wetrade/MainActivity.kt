package com.example.wetrade

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wetrade.ui.HomePage
import com.example.wetrade.ui.LoginPage
import com.example.wetrade.ui.WelcomePage
import com.example.wetrade.ui.theme.WeTradeTheme

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {

    enum class Page {
        Welcome, Login
    }

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BarUtils.transparentStatusBar(this)
        setContent {
            WeTradeTheme {
                var page: Page by remember {
                    mutableStateOf(Page.Welcome)
                }
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "welcome") {
                    composable("welcome") {
                        WelcomePage(navController)
                    }
                    composable("login") {
                        LoginPage(navController)
                    }
                    composable("home") {
                        HomePage(navController)
                    }
                }
            }
        }
    }

}

object BarUtils {

    var window: Window? = null

    fun transparentStatusBar(activity: Activity) {
        transparentStatusBar(activity.window)
        window = activity.window
    }

    fun lightStatusBar(){
        if(window != null){
            window!!.decorView.systemUiVisibility = window!!.decorView.systemUiVisibility or
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }

    fun darkStatusBar(){
        if(window != null){
            window!!.decorView.systemUiVisibility = window!!.decorView.systemUiVisibility xor
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }

    private fun transparentStatusBar(window: Window) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        val option = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        val vis = window.decorView.systemUiVisibility
        window.decorView.systemUiVisibility = option or vis
        window.statusBarColor = Color.TRANSPARENT
    }
}