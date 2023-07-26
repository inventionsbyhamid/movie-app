package app.aihunt.movie.domain.model

data class Movie(
    val imageUrl: String,
    val id: Long,
    val title: String,
    val description: String,
) {
    companion object {
        fun getSampleMovies() = listOf<Movie>(
            Movie("", 1, "Movie 1", "Movie 1 Description"),
            Movie("", 2, "Movie 2", "Movie 2 Description"),
            Movie("", 3, "Movie 3", "Movie 3 Description"),
            Movie("", 4, "Movie 4", "Movie 4 Description"),
        )

        fun getSampleMovie() = Movie("", 1, "Movie 1", "Movie 1 Description")
    }
}

