package com.example.thousandcoursesapp.ui.host

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.thousandcoursesapp.ui.favorites.FavoritesScreen
import com.example.thousandcoursesapp.ui.login.LoginScreen
import com.example.thousandcoursesapp.ui.main.MainScreen

enum class AppScreensEnum(val route: String) {
    Login("login_screen"),
    Favorites("favorites_screen"),
    Main("main_screen")
}

@Composable
fun AppHost(navController: NavHostController, paddding: PaddingValues) {
    fun navigateTo(screen: AppScreensEnum) {
        navController.navigate(screen.route) {
            launchSingleTop = true
        }
    }

    NavHost(
        navController = navController,
        startDestination = AppScreensEnum.Main.route,
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
    }
}