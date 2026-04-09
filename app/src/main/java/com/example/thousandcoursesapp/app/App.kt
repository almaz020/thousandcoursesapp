package com.example.thousandcoursesapp.app

import android.app.Application
import com.example.thousandcoursesapp.app.core.database.di.databaseModule
import com.example.thousandcoursesapp.app.core.network.di.networkModule
import com.example.thousandcoursesapp.app.feature_auth.di.authModule
import com.example.thousandcoursesapp.app.feature_courses.di.coursesModule
import com.example.thousandcoursesapp.app.feature_favorites.di.favoritesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                networkModule,
                coursesModule,
                authModule,
                databaseModule,
                favoritesModule
            )
        }
    }
}