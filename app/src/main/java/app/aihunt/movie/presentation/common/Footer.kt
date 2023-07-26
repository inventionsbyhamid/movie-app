package app.aihunt.movie.presentation.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.aihunt.movie.R

@Composable
@Preview
fun Footer(modifier: Modifier = Modifier) {
    Text(
        stringResource(id = R.string.footer),
        color = Color.LightGray,
        modifier = modifier.padding(8.dp)
    )
}