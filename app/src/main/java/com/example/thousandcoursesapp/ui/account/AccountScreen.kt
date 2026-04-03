package com.example.thousandcoursesapp.ui.account

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.example.thousandcoursesapp.R

@Composable
fun AccountScreen(
    modifier: Modifier = Modifier,
) {
    var text by rememberSaveable() { mutableStateOf("") }
    Box(modifier = modifier.fillMaxSize()) {
        Text(text = "AccountScreen", color = Color.White)
        TextField(
            value = text,
            onValueChange = {text = it}
        )
    }
}