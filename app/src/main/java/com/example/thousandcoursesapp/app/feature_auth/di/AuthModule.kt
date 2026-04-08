package com.example.thousandcoursesapp.app.feature_auth.di

import com.example.thousandcoursesapp.app.feature_auth.presentation.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val authModule = module {

    viewModel {
        LoginViewModel()
    }
}