package presentation.navigation

sealed class Screen {
    data object Dashboard : Screen()
    data object AddEvent : Screen()
}