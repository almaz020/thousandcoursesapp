package com.example.thousandcoursesapp.ui.bottombar

import android.net.http.SslCertificate.saveState
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
import com.example.thousandcoursesapp.ui.host.AppScreens

@Composable
fun BottomBar(navController: NavController) {

    val items = listOf(AppScreens.Main, AppScreens.Favorites, AppScreens.Account)

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
                        popUpTo(AppScreens.Main.route) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(Icons.Default.Home, contentDescription = null)
                },
                label = {
                    Text(screen.name)
                }
            )
        }
    }
}