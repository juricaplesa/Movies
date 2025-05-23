package com.juricaplesa.movies_ui.filter

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MoviesFilterScreen(
    onSelect: (Int) -> Unit,
    viewModel: MoviesFilterViewModel = hiltViewModel()
) {

    MoviesFilterContent(
        onSelect = onSelect
    )
}

@Composable
fun MoviesFilterContent(
    onSelect: (Int) -> Unit,
) {

    Button(onClick = { onSelect(2) }) { Text("Back") }
}

@Composable
@Preview
fun MoviesFilterPreview() {
    MoviesFilterContent(
        onSelect = {}
    )
}