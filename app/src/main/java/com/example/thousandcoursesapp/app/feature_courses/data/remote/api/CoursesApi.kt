package com.example.thousandcoursesapp.app.feature_courses.data.remote.api

import com.example.thousandcoursesapp.app.feature_courses.data.remote.dto.CoursesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface CoursesApi {

    @GET
    suspend fun getCourses(
        @Url url: String
    ): Response<CoursesResponse>
}