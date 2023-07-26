package app.aihunt.movie.presentation.features.movies

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.aihunt.movie.R
import app.aihunt.movie.domain.model.Movie
import app.aihunt.movie.presentation.theme.MovieAppTheme
import coil.compose.AsyncImage

@Composable
fun MovieItem(
    modifier: Modifier = Modifier,
    movie: Movie,
    onNavigateToMovieDetailScreen: (movie: Movie) -> Unit = { }
) {
    Card(
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .clickable { onNavigateToMovieDetailScreen(movie) }) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = movie.imageUrl,
                contentDescription = movie.title, modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(4.dp, MaterialTheme.colorScheme.primary, CircleShape),
                placeholder = painterResource(R.drawable.logo),
                error = painterResource(R.drawable.logo),
                contentScale = ContentScale.FillBounds
            )
            Spacer(Modifier.width(8.dp))
            Column(modifier = Modifier.padding(vertical = 8.dp, horizontal = 4.dp)) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(8.dp))
                Text(text = movie.description)
            }

        }
    }
}

@Composable
@Preview
fun MovieItemPreview() {
    MovieAppTheme {
        MovieItem(Modifier, movie = Movie("", 1, "Iron Man", "Best Movie Ever"))
    }
}