package com.example.thousandcoursesapp.app.feature_courses.di

import com.example.thousandcoursesapp.app.feature_courses.data.repository.CoursesRepositoryImpl
import com.example.thousandcoursesapp.app.feature_courses.domain.CoursesRepository
import com.example.thousandcoursesapp.app.feature_courses.domain.GetCoursesUseCase
import com.example.thousandcoursesapp.app.feature_courses.presentation.viewmodel.CoursesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val coursesModule = module {

    single<CoursesRepository> {
        CoursesRepositoryImpl(get())
    }

    factory {
        GetCoursesUseCase(get())
    }

    viewModel {
        CoursesViewModel(get())
    }
}