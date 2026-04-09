package com.example.thousandcoursesapp.app.feature_courses.di

import com.example.thousandcoursesapp.app.feature_courses.data.repository.CoursesRepositoryImpl
import com.example.thousandcoursesapp.app.feature_courses.domain.CoursesRepository
import com.example.thousandcoursesapp.app.feature_courses.domain.usecase.GetCoursesUseCase
import com.example.thousandcoursesapp.app.feature_favorites.domain.usecase.GetFavoriteCoursesUseCase
import com.example.thousandcoursesapp.app.feature_courses.domain.usecase.ToggleFavoriteUseCase
import com.example.thousandcoursesapp.app.feature_courses.presentation.viewmodel.CoursesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val coursesModule = module {

    single<CoursesRepository> {
        CoursesRepositoryImpl(get(), get())
    }

    factory {
        ToggleFavoriteUseCase(get())
    }

    factory {
        GetCoursesUseCase(get())
    }

    viewModel {
        CoursesViewModel(get(), get())
    }
}