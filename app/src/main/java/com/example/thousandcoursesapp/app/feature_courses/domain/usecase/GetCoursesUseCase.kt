package com.example.thousandcoursesapp.app.feature_courses.domain.usecase

import com.example.thousandcoursesapp.app.feature_courses.domain.CoursesRepository
import com.example.thousandcoursesapp.app.feature_courses.domain.model.Course
import kotlinx.coroutines.flow.Flow

class GetCoursesUseCase(
    private val repository: CoursesRepository
) {
    operator fun invoke(): Flow<List<Course>> {
        return repository.getCourses()
    }
}