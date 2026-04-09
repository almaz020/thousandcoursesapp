package com.example.thousandcoursesapp.app.feature_favorites.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thousandcoursesapp.app.feature_courses.domain.model.Course
import com.example.thousandcoursesapp.app.feature_courses.domain.usecase.ToggleFavoriteUseCase
import com.example.thousandcoursesapp.app.feature_favorites.domain.usecase.GetFavoriteCoursesUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val getFavoriteCoursesUseCase: GetFavoriteCoursesUseCase,
    private val toggleFavoriteUseCase: ToggleFavoriteUseCase
) : ViewModel() {

    val favorites: StateFlow<List<Course>> =
        getFavoriteCoursesUseCase()
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                emptyList()
            )
    fun toggleFavorite(id: Int) {
        viewModelScope.launch {
            toggleFavoriteUseCase(id)
        }
    }
}