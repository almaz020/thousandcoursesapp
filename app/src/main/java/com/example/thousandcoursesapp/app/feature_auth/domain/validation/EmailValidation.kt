package com.example.thousandcoursesapp.app.feature_auth.domain.validation

fun isValidEmail(email: String): Boolean {
    // Стандартное регулярное выражение для email (латиница, цифры, спецсимволы)
    val emailRegex = Regex(
        "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    )
    return email.isNotBlank() && emailRegex.matches(email)
}