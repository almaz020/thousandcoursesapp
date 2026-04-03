package com.example.thousandcoursesapp.ui.bottombar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.thousandcoursesapp.R
import com.example.thousandcoursesapp.ui.host.AppScreensEnum

@Composable
fun BottomBar(navController: NavController) {

    val items = listOf(AppScreensEnum.Main, AppScreensEnum.Favorites, AppScreensEnum.Account)

    NavigationBar(
        containerColor = colorResource(R.color.black_for_login_screen)
    ) {
        val currentRoute =
            navController.currentBackStackEntryAsState().value?.destination?.route

        items.forEach { screen ->
            NavigationBarItem(
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(AppScreensEnum.Main.route)
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(Icons.Default.Home, contentDescription = null)
                },
                label = {
                    Text(screen.route)
                }
            )
        }
    }
}