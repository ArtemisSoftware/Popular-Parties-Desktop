package presentation.addevent.composables

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FindInPage
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import core.ui.composables.button.PPCircularIconButton
import presentation.util.UrlUtil

@Composable
internal fun EventDetails(
    url: String,
    onGetHtmlCode: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {

    }
}



@Preview
@Composable
private fun EventDetailsPreview() {
    EventDetails(
        modifier = Modifier.fillMaxWidth(),
        url = "",
        onGetHtmlCode = {}
    )
}