package com.example.thousandcoursesapp.app.feature_courses.data.mapper

import com.example.thousandcoursesapp.app.feature_courses.data.remote.dto.CourseDto
import com.example.thousandcoursesapp.app.feature_courses.domain.model.Course

fun CourseDto.toDomain(): Course {
    return Course(
        id = id,
        title = title,
        description = text,
        price = price.replace(" ", "").toInt(),
        rate = rate.toDouble(),
        startDate = startDate,
        isFavorite = hasLike,
        publishDate = publishDate
    )
}