package app.aihunt.movie.presentation.features.movies

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.aihunt.movie.domain.model.Movie
import app.aihunt.movie.presentation.theme.MovieAppTheme
import coil.compose.AsyncImage

@Composable
fun MovieDetail(movie: Movie) {
    Column {
        Box {
            AsyncImage(
                model = movie.imageUrl,
                contentDescription = movie.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            )
            Text(
                text = movie.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(8.dp)
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = movie.description,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(8.dp)
        )

    }
}

@Composable
@Preview
fun MovieDetailPreview(movie: Movie = Movie.getSampleMovie()) {
    MovieAppTheme {
        MovieDetail(movie = movie)
    }
}