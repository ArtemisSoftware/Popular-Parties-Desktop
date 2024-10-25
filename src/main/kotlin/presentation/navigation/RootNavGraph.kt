package presentation.navigation

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import presentation.addevent.AddEventScreen
import presentation.dashboard.DashboardScreen

@Composable
fun RootNavGraph() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Dashboard) }

    when (currentScreen) {
        Screen.AddEvent -> AddEventScreen(onNavigateBack = { currentScreen = Screen.Dashboard })
        Screen.Dashboard -> DashboardScreen(navigateToAddEvent = { currentScreen = Screen.AddEvent })
    }
}