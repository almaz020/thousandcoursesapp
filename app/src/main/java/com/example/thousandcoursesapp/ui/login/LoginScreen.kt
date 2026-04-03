package com.example.thousandcoursesapp.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAbsoluteAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thousandcoursesapp.R

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    var email by rememberSaveable { mutableStateOf("") }
    val isEmailValid = isValidEmail(email)
    var password by rememberSaveable { mutableStateOf("") }
    Box(
        modifier = modifier.fillMaxSize().background(colorResource(R.color.black_for_login_screen))
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp, top = 100.dp)
        ) {
            Text(
                modifier = Modifier,
                text = stringResource(R.string.login),
                color = colorResource(R.color.white_for_login_screen),
                fontSize = 28.sp,
                fontFamily = FontFamily(Font(R.font.roboto_regular))
            )

            Spacer(modifier = Modifier.height(28.dp))

            Column(
                modifier = modifier
            ) {
                Text(
                    modifier = Modifier,
                    text = stringResource(R.string.email),
                    color = colorResource(R.color.white_for_login_screen),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        fontSize = 16.sp,
                        letterSpacing = 0.15.sp
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                BasicTextField(
                    value = email,
                    onValueChange = {email = it},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(colorResource(R.color.color_for_container)),
                    singleLine = true,
                    cursorBrush = SolidColor(colorResource(R.color.white_for_login_screen)),
                    textStyle = TextStyle(
                        color = colorResource(R.color.white_for_login_screen),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular))
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 11.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            if (email.isEmpty()) {
                                Text(
                                    modifier = Modifier.alpha(0.5f),
                                    text = stringResource(R.string.email_placeholder),
                                    style = TextStyle(
                                        color = colorResource(R.color.white_for_login_screen),
                                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                                        fontSize = 14.sp,
                                        letterSpacing = 0.2.sp
                                    )
                                )
                            }
                            innerTextField()
                        }
                    }
                )

            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = modifier
            ) {
                Text(
                    modifier = Modifier,
                    text = stringResource(R.string.password),
                    color = colorResource(R.color.white_for_login_screen),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        fontSize = 16.sp,
                        letterSpacing = 0.15.sp
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                BasicTextField(
                    value = password,
                    onValueChange = {password = it},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(colorResource(R.color.color_for_container)),
                    singleLine = true,
                    cursorBrush = SolidColor(colorResource(R.color.white_for_login_screen)),
                    textStyle = TextStyle(
                        color = colorResource(R.color.white_for_login_screen),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular))
                    ),
                    keyboardOptions = KeyboardOptions.Default,
                    visualTransformation = PasswordVisualTransformation(),
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 11.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            if (password.isEmpty()) {
                                Text(
                                    modifier = Modifier.alpha(0.5f),
                                    text = stringResource(R.string.password_placeholder),
                                    style = TextStyle(
                                        color = colorResource(R.color.white_for_login_screen),
                                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                                        fontSize = 14.sp,
                                        letterSpacing = 0.2.sp
                                    )
                                )
                            }
                            innerTextField()
                        }
                    }
                )

            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                enabled = isEmailValid,
                onClick = onClick,
                modifier = Modifier.fillMaxWidth().height(40.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(R.color.white_for_login_screen),
                    containerColor = colorResource(R.color.green_for_login_screen),
                    disabledContainerColor = colorResource(R.color.green_for_login_screen),
                    disabledContentColor = colorResource(R.color.white_for_login_screen)
                ),
                contentPadding = PaddingValues(vertical = 10.dp, horizontal = 147.5.dp)
            ) {
                Text(
                    text = stringResource(R.string.login),
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        color = colorResource(R.color.white_for_login_screen),
                        fontFamily = FontFamily(Font(R.font.roboto_regular))
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier.fillMaxWidth()//.padding(horizontal = 96.dp)
                ,horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row {
                    Text(
                        text = stringResource(R.string.not_have_account),
                        style = TextStyle(
                            color = colorResource(R.color.white_for_login_screen),
                            fontSize = 12.sp,
                            lineHeight = 15.sp,
                            letterSpacing = 0.4.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_semibold))
                        )
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = stringResource(R.string.registration),
                        style = TextStyle(
                            color = colorResource(R.color.green_for_login_screen),
                            fontSize = 12.sp,
                            lineHeight = 15.sp,
                            letterSpacing = 0.4.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_semibold))
                        )
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    modifier = Modifier,
                    text = stringResource(R.string.forgot_password),
                    style = TextStyle(
                        color = colorResource(R.color.green_for_login_screen),
                        fontSize = 12.sp,
                        lineHeight = 15.sp,
                        letterSpacing = 0.4.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_semibold))
                    ),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            HorizontalDivider(
                modifier = Modifier,
                thickness = 1.dp,
                color = colorResource(R.color.for_divider)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.clip(RoundedCornerShape(30.dp)),
                    painter = painterResource(R.drawable.vk_image),
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(16.dp))

                Image(
                    modifier = Modifier.clip(RoundedCornerShape(30.dp)),
                    painter = painterResource(R.drawable.odnokl_image),
                    contentDescription = null
                )
            }
        }
    }
}
fun isValidEmail(email: String): Boolean {
    // Стандартное регулярное выражение для email (латиница, цифры, спецсимволы)
    val emailRegex = Regex(
        "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    )
    return email.isNotBlank() && emailRegex.matches(email)
}
