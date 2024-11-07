package presentation.addevent.composables

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FindInPage
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import core.ui.composables.button.PPCircularIconButton
import domain.util.extensions.format
import presentation.addevent.AddEventState
import presentation.addevent.models.Event
import presentation.util.UrlUtil

@Composable
internal fun EventDetails(
    event: Event,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Evento",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.displayMedium,
        )
        Divider(modifier = Modifier.fillMaxWidth())

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Detail(
                    title = "Titulo",
                    description = event.title,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                Detail(
                    title = "Descrição",
                    description = event.description,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                Detail(
                    title = "Inicio",
                    description = event.startDate.format(),
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                Detail(
                    title = "Fim",
                    description = event.endDate.format(),
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                Detail(
                    title = "Horário",
                    description = event.workingHours ?: "---",
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                Detail(
                    title = "Preço",
                    description = event.price,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                Detail(
                    title = "Informação adicional",
                    description = event.extraInfo ?: "------",
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                Detail(
                    title = "Endereço",
                    description = event.address,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                Detail(
                    title = "Coordenadas",
                    description = event.coordinates.toString(),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
private fun Detail(
    title: String,
    description: String,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            text = description,
            fontSize = 16.sp,
        )
    }
}


@Preview
@Composable
private fun EventDetailsPreview() {
    EventDetails(
        modifier = Modifier.fillMaxWidth(),
        event = Event(),
    )
}