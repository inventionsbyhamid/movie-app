package app.aihunt.movie.presentation.features.movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import app.aihunt.movie.R
import app.aihunt.movie.domain.model.Movie
import app.aihunt.movie.presentation.common.DefaultDialog

@Composable
fun MovieDetailScreen(
    viewModel: MovieVM,
    onBackPress: () -> Unit
) {
    val state: MoviesUiState by viewModel.uiState.collectAsStateWithLifecycle()

    state.selectedMovie?.let {
        var showDialog by remember {
            mutableStateOf(false)
        }
        if (showDialog) {
            DefaultDialog(
                stringResource(id = R.string.about),
                onDismiss = { showDialog = false },
                stringResource(id = R.string.about_description)
            )
        }

        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = onBackPress) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back_button)
                    )
                }
                IconButton(onClick = { showDialog = true }) {
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = stringResource(id = R.string.info_button)
                    )
                }

            }
            MovieDetail(it)
        }
    }

}

@Composable
@Preview
fun PreviewMovieDetail() {
    MovieDetail(movie = Movie.getSampleMovie())
}