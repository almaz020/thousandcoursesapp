package com.example.thousandcoursesapp.app.feature_courses.domain

import kotlinx.coroutines.flow.Flow

interface CoursesRepository {

    fun getCourses(): Flow<List<Course>>

    suspend fun toggleFavorite(courseId: Int)
}