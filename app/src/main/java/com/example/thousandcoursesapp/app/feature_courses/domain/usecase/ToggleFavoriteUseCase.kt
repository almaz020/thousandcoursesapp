package com.example.thousandcoursesapp.app.feature_courses.domain.usecase

import com.example.thousandcoursesapp.app.feature_courses.domain.CoursesRepository

class ToggleFavoriteUseCase(
    private val repository: CoursesRepository
) {
    suspend operator fun invoke(courseId: Int) {
        repository.toggleFavorite(courseId)
    }
}