package com.example.thousandcoursesapp.app.feature_courses.data.repository

import com.example.thousandcoursesapp.app.feature_courses.data.mapper.toDomain
import com.example.thousandcoursesapp.app.feature_courses.data.remote.api.CoursesApi
import com.example.thousandcoursesapp.app.feature_courses.domain.Course
import com.example.thousandcoursesapp.app.feature_courses.domain.CoursesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CoursesRepositoryImpl(
    private val api: CoursesApi
) : CoursesRepository {

    override fun getCourses(): Flow<List<Course>> = flow {

        val response = api.getCourses(URL)

        if (response.isSuccessful) {

            val courses = response.body()
                ?.courses
                ?.map { it.toDomain() }
                ?: emptyList()

            emit(courses)

        } else {
            throw Exception("Error ${response.code()}")
        }
    }

    override suspend fun toggleFavorite(courseId: Int) {

    }

    companion object {
        private const val URL =
            "https://drive.usercontent.google.com/u/0/uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download"
    }
}