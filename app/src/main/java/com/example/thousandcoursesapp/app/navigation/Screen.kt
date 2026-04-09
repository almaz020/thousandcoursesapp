package com.example.thousandcoursesapp.app.navigation

sealed class Screen(val route: String) {

    object Login : Screen("login")
    object Main : Screen("main")
    object Courses : Screen("courses")
    object Favorites : Screen("favorites")
    object Profile : Screen("profile")
}