package com.example.thousandcoursesapp.app.feature_favorites.di

import org.koin.androidx.viewmodel.dsl.viewModel
import com.example.thousandcoursesapp.app.feature_favorites.domain.usecase.GetFavoriteCoursesUseCase
import com.example.thousandcoursesapp.app.feature_favorites.presentation.viewmodel.FavoritesViewModel
import org.koin.dsl.module

val favoritesModule = module {
    factory {
        GetFavoriteCoursesUseCase(get())
    }
    viewModel { FavoritesViewModel(get(), get()) }
}