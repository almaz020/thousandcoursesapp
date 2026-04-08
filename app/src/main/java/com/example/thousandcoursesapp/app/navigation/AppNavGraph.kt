package com.example.thousandcoursesapp.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.thousandcoursesapp.app.feature_auth.presentation.screen.LoginScreen
import com.example.thousandcoursesapp.app.feature_courses.presentation.screen.CoursesScreen

@Composable
fun AppNavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        composable("login") {
            LoginScreen(
                onClick = {
                    navController.navigate("courses") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }

        composable("courses") {
            CoursesScreen()
        }
    }
}