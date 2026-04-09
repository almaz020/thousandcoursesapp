package com.example.thousandcoursesapp.app.feature_favorites.domain.usecase

import com.example.thousandcoursesapp.app.feature_courses.domain.CoursesRepository
import com.example.thousandcoursesapp.app.feature_courses.domain.model.Course
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetFavoriteCoursesUseCase(
    private val repository: CoursesRepository
) {
    operator fun invoke(): Flow<List<Course>> {
        return repository.getCourses()
            .map { list -> list.filter { it.isFavorite } }
    }
}