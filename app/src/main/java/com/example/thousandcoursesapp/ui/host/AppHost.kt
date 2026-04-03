package com.example.thousandcoursesapp.ui.host

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.thousandcoursesapp.ui.account.AccountScreen
import com.example.thousandcoursesapp.ui.favorites.FavoritesScreen
import com.example.thousandcoursesapp.ui.login.LoginScreen
import com.example.thousandcoursesapp.ui.main.MainScreen

sealed class AppScreensEnum(
    val route: String,
    val showBottomBar: Boolean,
) {
    object Login : AppScreensEnum("login_screen", false)
    object Favorites : AppScreensEnum("favorites_screen", true)
    object Main : AppScreensEnum("main_screen", true)
    object Account: AppScreensEnum("account_screen", true)
}

@Composable
fun AppHost(
    navController: NavHostController,
    modifier: Modifier
) {
    fun navigateTo(screen: AppScreensEnum) {
        navController.navigate(screen.route) {
            launchSingleTop = true
        }
    }

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = AppScreensEnum.Login.route,
    ) {
        composable(AppScreensEnum.Main.route) {
            MainScreen(

            )
        }
        composable(AppScreensEnum.Favorites.route) {
            FavoritesScreen(

            )
        }
        composable(AppScreensEnum.Login.route) {
            LoginScreen(
                onClick = { navigateTo(AppScreensEnum.Main) }
            )
        }
        composable(AppScreensEnum.Account.route) {
            AccountScreen(

            )
        }
    }
}