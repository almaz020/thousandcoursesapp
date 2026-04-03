package com.example.thousandcoursesapp.ui.host

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
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
    val title: String,
) {
    object Login : AppScreensEnum("login_screen", "Логин")
    object Favorites : AppScreensEnum("favorites_screen", "Избранное")
    object Main : AppScreensEnum("main_screen", "Главная")
    object Account: AppScreensEnum("account_screen", "Аккаунт")
}

@Composable
fun AppHost(navController: NavHostController) {
    fun navigateTo(screen: AppScreensEnum) {
        navController.navigate(screen.route) {
            launchSingleTop = true
        }
    }

    NavHost(
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
                onClick = {}
            )
        }
        composable(AppScreensEnum.Main.route) {
            AccountScreen(

            )
        }
    }
}