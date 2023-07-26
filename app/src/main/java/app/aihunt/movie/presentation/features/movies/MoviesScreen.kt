package app.aihunt.movie.presentation.features.movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import app.aihunt.movie.R
import app.aihunt.movie.domain.model.Movie
import app.aihunt.movie.presentation.common.Footer
import app.aihunt.movie.presentation.common.Header
import app.aihunt.movie.presentation.common.Loader

@Composable
fun MoviesScreen(
    viewModel: MovieVM,
    onNavigateToMovieDetailScreen: (movie: Movie) -> Unit = {},
) {
    val state: MoviesUiState by viewModel.uiState.collectAsStateWithLifecycle()

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxSize()
    ) {

        if (state.loading) {
            Loader()
        } else if (state.error == null) {
            LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
                item(contentType = "Text") {
                    Header(
                        modifier = Modifier.padding(8.dp),
                        text = stringResource(id = R.string.movie_list)
                    )
                }
                items(
                    state.movies,
                    key = { movie -> movie.id },
                    contentType = { "Movie" }) { movie ->
                    MovieItem(
                        movie = movie,
                        onNavigateToMovieDetailScreen = onNavigateToMovieDetailScreen
                    )
                }
                item(contentType = "Text") {
                    Footer()
                }
            }
        }
        if (state.error != null && !state.loading) {
            Button(onClick = { viewModel.getMovies() }) {
                Text(text = stringResource(id = R.string.retry))
            }
        }
    }
}