package com.example.thousandcoursesapp.app.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.thousandcoursesapp.R

@Composable
fun BottomBar(
    navController: NavHostController
) {

    val items = listOf(NavItem.Courses, NavItem.Favorites, NavItem.Profile)

    NavigationBar(
        //modifier = Modifier.background(colorResource(R.color.black_for_main_screen)),
        containerColor = colorResource(R.color.black_for_main_screen), // фон всей панели
        contentColor = colorResource(R.color.green_for_login_screen), // цвет иконок и текста по умолчанию
        tonalElevation = 0.dp
    ) {

        val currentRoute = currentRoute(navController)

        items.forEach { item ->
            val selected = currentRoute == item.route
            NavigationBarItem(
                selected = currentRoute?.startsWith(item.route) == true,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    if (selected) {
                        Box(
                            modifier = Modifier
                                .size(width = 64.dp, height = 32.dp)
                                .background(
                                    color = colorResource(R.color.color_for_container),
                                    shape = RoundedCornerShape(16.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(item.iconRes), // лучше использовать выбранную иконку
                                contentDescription = null,
                            )
                        }
                    } else {
                        // Невыбранное состояние — просто иконка без фона
                        Icon(
                            painter = painterResource(item.iconRes),
                            contentDescription = null,
                        )
                    }

                },
                label = {
                    Text(
                        modifier = Modifier,
                        text = item.title,
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 16.sp,
                            letterSpacing = 0.5.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_semibold))
                        )
                    )
                } ,
                colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = colorResource(R.color.green_for_login_screen),      // цвет иконки при выборе
                    selectedTextColor = colorResource(R.color.green_for_login_screen),      // цвет текста при выборе
                    unselectedIconColor = Color.White,    // цвет иконки по умолчанию
                    unselectedTextColor = Color.White,    // цвет текста по умолчанию
                    indicatorColor = Color.Transparent    // убирает стандартный индикатор (кружок/подложку)
            ),
            )
        }
    }
}
sealed class NavItem(val route: String, val title: String, val iconRes: Int) {
    object Courses : NavItem("courses", "Главная", R.drawable.home)
    object Favorites : NavItem("favorites", "Избранное", R.drawable.favorites )
    object Profile : NavItem("profile", "Профиль", R.drawable.account)
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}