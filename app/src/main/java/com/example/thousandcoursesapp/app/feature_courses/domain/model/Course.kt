package com.example.thousandcoursesapp.app.feature_courses.domain.model

data class Course(
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val rate: Double,
    val startDate: String,
    val isFavorite: Boolean,
    val publishDate: String
)