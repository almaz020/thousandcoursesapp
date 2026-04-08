package com.example.thousandcoursesapp.app.feature_courses.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thousandcoursesapp.app.feature_courses.domain.GetCoursesUseCase
import com.example.thousandcoursesapp.app.feature_courses.presentation.model.CoursesState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class CoursesViewModel(
    private val getCoursesUseCase: GetCoursesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<CoursesState>(CoursesState.Loading)
    val state: StateFlow<CoursesState> = _state

    init {
        loadCourses()
    }

    fun loadCourses() {
        viewModelScope.launch {
            getCoursesUseCase()
                .onStart {
                    _state.value = CoursesState.Loading
                }
                .catch {
                    _state.value = CoursesState.Error("Ошибка загрузки")
                }
                .collect { courses ->
                    _state.value = CoursesState.Success(courses)
                }
        }
    }
}