package com.example.thousandcoursesapp.app.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class FavoriteCourseEntity(
    @PrimaryKey val id: Int
)