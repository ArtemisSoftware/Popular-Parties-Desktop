package presentation.dashboard.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ListAlt
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DashboardOption(val icon: ImageVector, val description: String) {
    data object AddEvent: DashboardOption(icon = Icons.Filled.Bolt, description = "Adicionar evento")
    data object EventList: DashboardOption(icon = Icons.AutoMirrored.Filled.ListAlt, description = "Listagem de eventos")
}