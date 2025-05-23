package com.juricaplesa.movies_ui.list

import androidx.lifecycle.ViewModel
import com.juricaplesa.movies_domain.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository
) : ViewModel() {

    private val _state: MutableStateFlow<MoviesListState> = MutableStateFlow(MoviesListState())
    val state = _state.asStateFlow()

    private val moviesIndexMap = mutableMapOf<String, Int>()


    fun onFilterChange(genreId: Int) {

    }

}