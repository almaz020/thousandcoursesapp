package com.example.thousandcoursesapp.app.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.thousandcoursesapp.app.feature_courses.presentation.screen.CoursesScreen
import com.example.thousandcoursesapp.app.feature_favorites.presentation.screen.FavoritesScreen
import com.example.thousandcoursesapp.R


@Composable
fun MainScreen(
    navController: NavHostController
) {

    val bottomNavController = rememberNavController()

    Column(modifier = Modifier.fillMaxSize()) {
        // NavHost занимает всё свободное место (кроме BottomBar)
        NavHost(
            navController = bottomNavController,
            startDestination = Screen.Courses.route,
            modifier = Modifier
                .weight(1f)          // занимает всё оставшееся пространство
                .fillMaxWidth()
        ) {
            composable(Screen.Courses.route) {
                CoursesScreen()
            }
            composable(Screen.Favorites.route) {
                FavoritesScreen()
            }
            composable(Screen.Profile.route) {
                Box(Modifier.fillMaxSize().background(colorResource(R.color.black_for_main_screen)), contentAlignment = Alignment.Center) {
                    Text("Profile Screen")
                }
            }
        }

        // Нижняя панель навигации
        BottomBar(navController = bottomNavController)
    }
}