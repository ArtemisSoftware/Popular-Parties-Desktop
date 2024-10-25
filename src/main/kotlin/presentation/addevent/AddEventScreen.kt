@file:OptIn(ExperimentalMaterial3Api::class)

package presentation.addevent

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import core.ui.composables.topbar.PPTopBar
import presentation.addevent.composables.EventDetails
import presentation.addevent.composables.HtmlViewer

@Composable
fun AddEventScreen(
    onNavigateBack: () -> Unit
) {
    AddEventContent(
        onNavigateBack = onNavigateBack
    )
}

@Composable
private fun AddEventContent(
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            PPTopBar(
                title = "Criar evento",
                onBackClick = onNavigateBack
            )
        },
        content = { innerPadding ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ){
                HtmlViewer(
                    url = "https://www.coolture.pt/event/feira-da-luz-2024-carnide-lisboa/",
                    onGetHtmlCode = {},
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                )

                EventDetails(
                    url = "https://www.coolture.pt/event/feira-da-luz-2024-carnide-lisboa/",
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    onGetHtmlCode = {
                    }
                )
            }
        }
    )
}

@Preview
@Composable
private fun AddEventContentPreview() {
    AddEventContent(
        onNavigateBack = {}
    )
}

