package com.example.thousandcoursesapp.app.feature_courses.domain

import kotlinx.coroutines.flow.Flow

class GetCoursesUseCase(
    private val repository: CoursesRepository
) {
    operator fun invoke(): Flow<List<Course>> {
        return repository.getCourses()
    }
}