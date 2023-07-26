package app.aihunt.movie.presentation.navigation

sealed class Screen(val route: String) {
    object Movies : Screen("movies")
}