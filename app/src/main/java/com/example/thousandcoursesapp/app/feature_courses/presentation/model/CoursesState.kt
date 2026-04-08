package com.example.thousandcoursesapp.app.feature_courses.presentation.model

import com.example.thousandcoursesapp.app.feature_courses.domain.Course

sealed class CoursesState {

    object Loading : CoursesState()

    data class Success(
        val courses: List<Course>
    ) : CoursesState()

    data class Error(
        val message: String
    ) : CoursesState()
}