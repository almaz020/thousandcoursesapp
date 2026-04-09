package com.example.thousandcoursesapp.app.feature_courses.data.repository

import com.example.thousandcoursesapp.app.core.database.dao.FavoritesDao
import com.example.thousandcoursesapp.app.core.database.entity.FavoriteCourseEntity
import com.example.thousandcoursesapp.app.feature_courses.data.mapper.toDomain
import com.example.thousandcoursesapp.app.feature_courses.data.remote.api.CoursesApi
import com.example.thousandcoursesapp.app.feature_courses.domain.model.Course
import com.example.thousandcoursesapp.app.feature_courses.domain.CoursesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

class CoursesRepositoryImpl(
    private val api: CoursesApi,
    private val dao: FavoritesDao
) : CoursesRepository {

    override fun getCourses(): Flow<List<Course>> {

        return combine(
            flow {
                val response = api.getCourses(URL)
                if (response.isSuccessful) {
                    emit(response.body()?.courses ?: emptyList())
                } else {
                    throw Exception("Error")
                }
            },
            dao.getFavorites()
        ) { coursesDto, favorites ->

            val favoriteIds = favorites.map { it.id }

            coursesDto.map { dto ->
                dto.toDomain().copy(
                    isFavorite = favoriteIds.contains(dto.id)
                )
            }
        }
    }

    override suspend fun toggleFavorite(courseId: Int) {

        val current = dao.getFavorites().first()

        if (current.any { it.id == courseId }) {
            dao.removeFromFavorites(courseId)
        } else {
            dao.addToFavorites(FavoriteCourseEntity(courseId))
        }
    }

    companion object {
        private const val URL =
            "https://drive.usercontent.google.com/u/0/uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download"
    }
}