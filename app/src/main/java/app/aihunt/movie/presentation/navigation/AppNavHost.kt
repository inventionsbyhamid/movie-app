package app.aihunt.movie.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.aihunt.movie.presentation.features.movies.MovieDetailScreen
import app.aihunt.movie.presentation.features.movies.MovieVM
import app.aihunt.movie.presentation.features.movies.MoviesScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.Movies.route
) {
    val viewModel: MovieVM = hiltViewModel()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Screen.Movies.route) {
            MoviesScreen(
                viewModel = viewModel,
                onNavigateToMovieDetailScreen = {
                    viewModel.onMovieClick(it)
                    navController.navigate(Screen.MovieDetail.route)
                },
            )
        }
        composable(route = Screen.MovieDetail.route) {
            MovieDetailScreen(
                viewModel = viewModel,
                onBackPress = {
                    navController.popBackStack()
                }
            )
        }
    }

}