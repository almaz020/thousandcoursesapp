package com.example.thousandcoursesapp.app.core.database.di

import androidx.room.Room
import com.example.thousandcoursesapp.app.core.database.AppDatabase
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "app_db"
        ).build()
    }

    single {
        get<AppDatabase>().favoritesDao()
    }
}