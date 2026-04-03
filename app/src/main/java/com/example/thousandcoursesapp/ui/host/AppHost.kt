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

sealed class AppScreens(
    val route: String,
    val showBottomBar: Boolean,
    val name: String,
) {
    object Login : AppScreens("login_screen", false, "Логин")
    object Favorites : AppScreens("favorites_screen", true, "Избранное")
    object Main : AppScreens("main_screen", true, "Главная")
    object Account: AppScreens("account_screen", true, "Аккаунт")
}

@Composable
fun AppHost(
    navController: NavHostController,
    modifier: Modifier
) {
    fun navigateTo(screen: AppScreens) {
        navController.navigate(screen.route) {
            launchSingleTop = true
        }
    }
    fun navigateFromLoginScreen() {
        navController.navigate(AppScreens.Main.route) {
            popUpTo(AppScreens.Login.route) {
                inclusive = true
            }
        }
    }

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = AppScreens.Login.route,
    ) {
        composable(AppScreens.Main.route) {
            MainScreen(

            )
        }
        composable(AppScreens.Favorites.route) {
            FavoritesScreen(

            )
        }
        composable(AppScreens.Login.route) {
            LoginScreen(
                onClick = { navigateFromLoginScreen() }
            )
        }
        composable(AppScreens.Account.route) {
            AccountScreen(

            )
        }
    }
}