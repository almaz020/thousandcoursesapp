package com.example.thousandcoursesapp.ui.activity

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.thousandcoursesapp.R
import com.example.thousandcoursesapp.ui.bottombar.BottomBar
import com.example.thousandcoursesapp.ui.host.AppHost
import com.example.thousandcoursesapp.ui.host.AppScreensEnum
import com.example.thousandcoursesapp.ui.systembars.SystemBars

@Composable
fun App() {

    val navController = rememberNavController()
    val backgroundColor = colorResource(R.color.black_for_login_screen)

    SystemBars(
        color = backgroundColor,
        darkIcons = false
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val currentScreen = when (currentRoute) {
        AppScreensEnum.Main.route -> AppScreensEnum.Main
        AppScreensEnum.Favorites.route -> AppScreensEnum.Favorites
        AppScreensEnum.Login.route -> AppScreensEnum.Login
        else -> null
    }
    Scaffold(
        containerColor = backgroundColor,
        bottomBar = {
            if (currentScreen?.showBottomBar == true) {
                BottomBar(navController)
            }
        }
    ) { padding ->
        AppHost(
            navController = navController,
            modifier = Modifier.padding(padding)
        )
    }
}