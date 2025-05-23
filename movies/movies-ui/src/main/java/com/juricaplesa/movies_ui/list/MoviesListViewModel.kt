package com.juricaplesa.movies_ui.list

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juricaplesa.movies_domain.MoviesRepository
import com.juricaplesa.movies_domain.model.Movie
import com.juricaplesa.movies_ui.navigation.Arguments
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository
) : ViewModel() {

    private val _state: MutableStateFlow<MoviesListState> = MutableStateFlow(MoviesListState())
    val state = _state.asStateFlow()

    private val moviesIndexMap = mutableMapOf<String, Int>()

    init {

        _state.update {
            it.copy(
                movies = listOf(
                    Movie(
                        id = 0,
                        name = "Test0"
                    ),
                    Movie(
                        id = 1,
                        name = "Test1"
                    )
                )
            )
        }
    }

    fun onFilterChange(genreId: Int) {

    }

}