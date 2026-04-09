package com.example.thousandcoursesapp.app.feature_courses.domain

import com.example.thousandcoursesapp.app.feature_courses.domain.model.Course
import kotlinx.coroutines.flow.Flow

interface CoursesRepository {

    fun getCourses(): Flow<List<Course>>

    suspend fun toggleFavorite(courseId: Int)
}