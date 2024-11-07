package presentation.addevent.composables

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.FindInPage
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import core.ui.composables.button.PPCircularIconButton
import presentation.util.UrlUtil


@Composable
internal fun EventMenu(
    url: String,
    onUrlChange: (String) -> Unit,
    onGetHtmlCode: (String) -> Unit,
    toggleHtmlCode: () -> Unit,
    modifier: Modifier = Modifier,
){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedTextField(
            value = url,
            label = { Text("Página web") },
            onValueChange = onUrlChange
        )

        Button(
            onClick = { onGetHtmlCode(url) },
            content = {
                Text("Obter html")
            }
        )
        PPCircularIconButton(
            onClick = {
                UrlUtil.openUrl(url = url)
            },
            icon = Icons.Filled.FindInPage
        )
        PPCircularIconButton(
            onClick = toggleHtmlCode,
            icon = Icons.Filled.Code
        )
    }
}

@Preview
@Composable
private fun EventMenuPreview() {
    EventMenu(
        modifier = Modifier.fillMaxWidth(),
        url = "",
        onGetHtmlCode = {},
        onUrlChange = {},
        toggleHtmlCode = {},
    )
}
