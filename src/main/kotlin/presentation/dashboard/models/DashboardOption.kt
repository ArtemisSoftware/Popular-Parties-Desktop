package presentation.dashboard.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DashboardOption(val icon: ImageVector, val description: String) {
    data object AddEvent: DashboardOption(icon = Icons.Filled.Bolt, description = "Adicionar evento")
}