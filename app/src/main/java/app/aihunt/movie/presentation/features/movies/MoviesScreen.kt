package app.aihunt.movie.presentation.features.movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import app.aihunt.movie.R
import app.aihunt.movie.presentation.theme.MovieAppTheme

@Composable
fun MoviesScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(id = R.string.movies_screen))
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewMoviesScreen() {
    MovieAppTheme {
        MoviesScreen()
    }
}