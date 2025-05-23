package com.juricaplesa.movies_ui.list

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MoviesListScreen(
    filterId: Int,
    onNavigateToFilter: () -> Unit,
    viewModel: MoviesListViewModel = hiltViewModel()
) {

    LaunchedEffect(filterId) {
        viewModel.onFilterChange(filterId)
    }

    MoviesListContent(
        state = viewModel.state.collectAsStateWithLifecycle().value,
        onNavigateToFilter = onNavigateToFilter
    )
}

@Composable
fun MoviesListContent(
    state: MoviesListState,
    onNavigateToFilter: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
    ) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {

            items(
                items = state.movies,
                key = { movie -> movie.id }
            ) { movie ->
                Text(
                    text = movie.name
                )
            }
        }

        FloatingActionButton(
            onClick = onNavigateToFilter,
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.BottomEnd)
        ) { }
    }
}

@Composable
@Preview
fun MoviesListPreview() {
    MoviesListContent(
        state = MoviesListState(),
        onNavigateToFilter = {}
    )
}