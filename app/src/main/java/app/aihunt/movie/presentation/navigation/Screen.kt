package app.aihunt.movie.presentation.navigation

sealed class Screen(val route: String) {
    object Movies : Screen("movies")
    object MovieDetail : Screen("movie_detail")

}