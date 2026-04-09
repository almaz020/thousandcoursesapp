package com.example.thousandcoursesapp.app.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.thousandcoursesapp.app.core.database.entity.FavoriteCourseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritesDao {

    @Query("SELECT * FROM favorites")
    fun getFavorites(): Flow<List<FavoriteCourseEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToFavorites(entity: FavoriteCourseEntity)

    @Query("DELETE FROM favorites WHERE id = :id")
    suspend fun removeFromFavorites(id: Int)
}