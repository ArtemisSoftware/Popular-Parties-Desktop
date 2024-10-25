package presentation.dashboard

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import presentation.dashboard.composables.OptionCard
import presentation.dashboard.models.DashboardOption
import presentation.dashboard.models.DashboardOptions

@Composable
fun DashboardScreen(
    navigateToAddEvent: () -> Unit
) {
    DashboardContent(
        navigateToAddEvent = navigateToAddEvent
    )
}

@Composable
private fun DashboardContent(
    navigateToAddEvent: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Dashboard",
            modifier = Modifier.align(Alignment.TopStart),
            textAlign = TextAlign.Start,
        )

        LazyVerticalGrid(
            modifier = Modifier.align(Alignment.Center),
            columns = GridCells.Fixed(3),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(
                items = DashboardOptions.options,
                key = { it.description }
            ) { option ->

                OptionCard(
                    option = option,
                    onClick = { item ->
                        navigateTo(
                            option = item,
                            navigateToAddEvent = navigateToAddEvent,
                        )
                    },
                    Modifier.fillMaxWidth()
                )
            }
        }
    }
}

private fun navigateTo(
    option: DashboardOption,
    navigateToAddEvent: () -> Unit
){
    when(option){
        DashboardOption.AddEvent -> navigateToAddEvent()
        DashboardOption.EventList -> TODO()
    }
}

@Preview
@Composable
private fun DashboardContentPreview() {
    DashboardContent(
        navigateToAddEvent = {}
    )
}