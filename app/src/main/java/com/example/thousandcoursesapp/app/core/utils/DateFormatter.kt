package com.example.thousandcoursesapp.app.core.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

object DateFormatter {

    fun format(date: String): String {
        val input = LocalDate.parse(date)
        val formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale("ru"))
        return input.format(formatter)
    }
}