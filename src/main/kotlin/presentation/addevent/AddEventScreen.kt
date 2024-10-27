@file:OptIn(ExperimentalMaterial3Api::class)

package presentation.addevent

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import core.ui.composables.topbar.PPTopBar
import presentation.addevent.composables.EventDetails
import presentation.addevent.composables.EventMenu
import presentation.addevent.composables.HtmlViewer

@Composable
fun AddEventScreen(
    onNavigateBack: () -> Unit,
    viewModel: AddEventViewModel = remember { AddEventViewModel() }
) {
    AddEventContent(
        onNavigateBack = onNavigateBack,
        state = viewModel.state.collectAsState().value,
        events = viewModel::onTriggerEvent,
    )
}

@Composable
private fun AddEventContent(
    onNavigateBack: () -> Unit,
    state: AddEventState,
    events: (AddEventEvent) -> Unit,
) {
    Scaffold(
        topBar = {
            PPTopBar(
                title = "Criar evento",
                onBackClick = onNavigateBack
            )
        },
        content = { innerPadding ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                EventMenu(
                    url = state.url,
                    onUrlChange = { events.invoke(AddEventEvent.UpdateSearchQuery(it)) },
                    onGetHtmlCode = { events.invoke(AddEventEvent.Search) },
                    toggleHtmlCode = { events.invoke(AddEventEvent.ToggleHtmlCode) },
                    modifier = Modifier.fillMaxWidth()
                )

                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ){
                    EventDetails(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(),
                        event = state.event
                    )

                    AnimatedVisibility(
                        visible = state.showHtmlCode,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                    ) {
                        HtmlViewer(
                            htmlContent = state.htmlContent,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }
                }
            }
        }
    )
}

@Preview
@Composable
private fun AddEventContentPreview() {
    AddEventContent(
        onNavigateBack = {},
        state = AddEventState(),
        events = {}
    )
}

