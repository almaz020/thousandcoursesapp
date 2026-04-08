package com.example.thousandcoursesapp.app.feature_courses.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thousandcoursesapp.R
import com.example.thousandcoursesapp.app.feature_courses.domain.Course
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeStyle
import dev.chrisbanes.haze.haze
import dev.chrisbanes.haze.hazeChild
import dev.chrisbanes.haze.hazeEffect
import dev.chrisbanes.haze.hazeSource

@Composable
fun CourseItem(

) {
    Box(
        modifier = Modifier
            .height(height = 236.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(colorResource(R.color.black_for_main_screen))
            .clickable(onClick = {}) // сюда передать переход на экран курса
    ) {
        Column {
            Box {
                Image(
                    modifier = Modifier.fillMaxWidth().height(114.dp).clip(RoundedCornerShape(12.dp)),
                    painter = painterResource(R.drawable.cover),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Image(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 8.dp, end = 8.dp),
                    painter = painterResource(R.drawable.bookmark),
                    contentDescription = null,
                )
                Row(
                    modifier = Modifier
                        .padding(top = 84.dp, start = 8.dp, bottom = 8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(height = 22.dp, width = 46.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(
                                color = colorResource(R.color.color_for_container).copy(alpha = 0.3f)
                            )

                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                modifier = Modifier.padding(top = 5.dp, start = 6.dp, bottom = 5.dp),
                                painter = painterResource(R.drawable.star),
                                contentDescription = null,
                            )
                            Spacer(Modifier.width(4.dp))
                            Text(
                                modifier = Modifier.padding(top = 4.dp, end = 6.dp, bottom = 4.dp),
                                text = course.rate.toString(),
                                style = TextStyle(
                                    color = colorResource(R.color.white_for_login_screen),
                                    fontSize = 12.sp,
                                    lineHeight = 14.sp,
                                    letterSpacing = 0.4.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_regular))
                                )
                            )
                        }

                    }
                    Spacer(Modifier.width(4.dp))
                    Box(
                        modifier = Modifier
                            .size(height = 22.dp, width = 87.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(
                                color = colorResource(R.color.color_for_container).copy(alpha = 0.3f)
                            )
                    ) {
                        Text(
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp),
                            text = "22 мая 2024", //здесь startDate, нужно написать конвертер даты
                            style = TextStyle(
                                color = colorResource(R.color.white_for_login_screen),
                                fontSize = 12.sp,
                                lineHeight = 14.sp,
                                letterSpacing = 0.4.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_regular))
                            )
                        )
                    }
                }
            }
            Spacer(Modifier.height(16.dp))
            
            Column(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            ) {
                Text(
                    modifier = Modifier,
                    text = course.title,
                    style = TextStyle(
                        color = colorResource(R.color.white_for_login_screen),
                        fontSize = 16.sp,
                        lineHeight = 18.sp,
                        letterSpacing = 0.15.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_medium))
                    )
                )
                Spacer(Modifier.height(12.dp))
                Text(
                    modifier = Modifier.alpha(0.7f),
                    text = course.description,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        color = colorResource(R.color.white_for_login_screen),
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        letterSpacing = 0.4.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular))
                    )
                )
                Spacer(Modifier.height(10.dp))
                Row(

                ) {
                    Text(
                        modifier = Modifier,
                        text = course.price.toString() + " ₽",
                        style = TextStyle(
                            color = colorResource(R.color.white_for_login_screen),
                            fontSize = 16.sp,
                            lineHeight = 18.sp,
                            letterSpacing = 0.15.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_medium))
                        )
                    )
                    Spacer(Modifier.width(175.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier,
                            text = stringResource(R.string.podrobnee),
                            style = TextStyle(
                                color = colorResource(R.color.green_for_login_screen),
                                fontSize = 12.sp,
                                lineHeight = 15.sp,
                                letterSpacing = 0.4.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_semibold))
                            )
                        )
                        Spacer(Modifier.width(4.dp))
                        Icon(
                            modifier = Modifier.padding(top = 2.dp),
                            painter = painterResource(R.drawable.arrow),
                            contentDescription = null,
                            tint = colorResource(R.color.green_for_login_screen)
                        )
                    }
                }
            }
        }
    }
}

val course = Course(
    id = 100,
    title = "Java-разработчик с нуля",
    description = "Освойте backend-разработку и программирование на Java, фреймворки Spring и Maven, работу с базами данных и API. Создайте свой собственный проект, собрав портфолио и став востребованным специалистом для любой IT компании.",
    price = 999,
    rate = 4.9,
    startDate = "2024-05-22",
    isFavorite = false,
    publishDate = "2024-02-02"
)


@Composable
@Preview(showSystemUi = true)
fun prev() {
    CourseItem()
}