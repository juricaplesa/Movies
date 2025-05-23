package com.juricaplesa.movies_ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.juricaplesa.movies_ui.filter.MoviesFilterScreen
import com.juricaplesa.movies_ui.list.MoviesListScreen

fun NavGraphBuilder.moviesGraph(
    navController: NavController
) {

    navigation(
        startDestination = Route.MOVIES_LIST,
        route = Route.MOVIES
    ) {

        composable(
            route = Route.MOVIES_LIST
        ) {
            val filterId =
                navController.currentBackStackEntry?.savedStateHandle?.get<Int>(Arguments.FILTER)
                    ?: -1
            MoviesListScreen(
                filterId = filterId,
                onNavigateToFilter = { navController.navigate(Route.MOVIES_FILTER + "/8") }
            )
        }

        composable(
            route = Route.MOVIES_FILTER + "/{${Arguments.FILTER}}",
            arguments = listOf(
                navArgument(Arguments.FILTER) {
                    type = NavType.IntType
                    nullable = true
                }
            )
        ) {

            MoviesFilterScreen(
                onSelect = { filterId ->
                    navController.popBackStack()
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        Arguments.FILTER,
                        filterId
                    )
                },
            )
        }
    }
}