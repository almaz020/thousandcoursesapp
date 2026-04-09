package com.example.thousandcoursesapp.app.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.thousandcoursesapp.app.core.database.dao.FavoritesDao
import com.example.thousandcoursesapp.app.core.database.entity.FavoriteCourseEntity

@Database(
    entities = [FavoriteCourseEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun favoritesDao(): FavoritesDao
}