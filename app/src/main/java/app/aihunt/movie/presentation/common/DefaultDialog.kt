package app.aihunt.movie.presentation.common

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import app.aihunt.movie.R

@Composable
fun DefaultDialog(title: String, onDismiss: () -> Unit, description: String = "") {

    val uriHandler = LocalUriHandler.current

    val styledMessage = messageFormatter(
        text = description,
        primary = true
    )

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(text = title)
        },
        text = {
            ClickableText(
                text = styledMessage,
                style = MaterialTheme.typography.bodyLarge.copy(color = LocalContentColor.current),
                modifier = Modifier.padding(16.dp),
                onClick = {
                    styledMessage
                        .getStringAnnotations(start = it, end = it)
                        .firstOrNull()
                        ?.let { annotation ->
                            when (annotation.tag) {
                                SymbolAnnotationType.LINK.name -> uriHandler.openUri(annotation.item)
                                else -> Unit
                            }
                        }
                }
            )
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(text = stringResource(id = R.string.ok))
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(text = stringResource(id = R.string.cancel))
            }
        }
    )
}