package com.example.thousandcoursesapp.app.feature_favorites.presentation.screen

import androidx.compose.animation.animateColorAsState
import com.example.thousandcoursesapp.app.feature_courses.presentation.screen.CourseItem

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thousandcoursesapp.R
import com.example.thousandcoursesapp.app.feature_courses.presentation.model.CoursesState
import com.example.thousandcoursesapp.app.feature_courses.presentation.viewmodel.CoursesViewModel
import com.example.thousandcoursesapp.app.feature_favorites.presentation.viewmodel.FavoritesViewModel
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoritesScreen(
    viewModel: FavoritesViewModel = koinViewModel(),
) {
    val courses by viewModel.favorites.collectAsState()


    Box(
        modifier = Modifier.fillMaxSize().background(colorResource(R.color.black_for_login_screen)),
    ) {
        Column(
            modifier = Modifier.padding(top = 56.dp, start = 16.dp, end = 16.dp)
        ) {
            Row {
                BasicTextField(
                    modifier = Modifier
                        .height(56.dp)
                        .weight(1f)
                        .clip(RoundedCornerShape(28.dp))
                        .background(colorResource(R.color.black_for_main_screen)),
                    value = "",
                    onValueChange = { },
                    readOnly = true,
                    decorationBox = { innerTextField ->
                        Row {
                            Image(
                                modifier = Modifier.padding(start = 18.dp, top = 18.dp, bottom = 18.dp),
                                painter = painterResource(R.drawable.search_icon),
                                contentDescription = null
                            )
                            Spacer(Modifier.width(18.dp))
                            Text(
                                modifier = Modifier.padding(vertical = 19.dp).alpha(0.5f),
                                text = stringResource(R.string.search_placeholder),
                                style = TextStyle(
                                    color = colorResource(R.color.white_for_login_screen),
                                    fontSize = 14.sp,
                                    lineHeight = 18.sp,
                                    letterSpacing = 0.25.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_regular))
                                )
                            )
                        }
                        innerTextField()
                    }
                )
                Spacer(Modifier.width(8.dp))
                Image(
                    modifier = Modifier,
                    painter = painterResource(R.drawable.filter),
                    contentDescription = null
                )
            }

            Spacer(Modifier.height(16.dp))

            Row(
                modifier = Modifier.align(Alignment.End).clickable {

                }, // сюда передать сортировку
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    modifier = Modifier,
                    text = stringResource(R.string.for_sort),
                    style = TextStyle(
                        color = colorResource(R.color.green_for_login_screen),
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        letterSpacing = 0.1.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_medium))
                    )
                )

                Spacer(Modifier.width(6.dp))

                Icon(
                    modifier = Modifier.align(Alignment.Bottom),
                    painter = painterResource(R.drawable.sort_icon),
                    contentDescription = null,
                    tint = colorResource(R.color.green_for_login_screen)
                )
            }

            Spacer(Modifier.height(16.dp))

            LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                items(courses) { course ->
                    CourseItem(
                        course = course,
                        onFavoriteClick = { id ->
                            viewModel.toggleFavorite(id)
                        }
                    )
                }
            }
        }



    }
}