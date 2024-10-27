package presentation.addevent

sealed class AddEventEvent {
    data class UpdateSearchQuery(val query: String) : AddEventEvent()
    data object Search : AddEventEvent()
    data object ToggleHtmlCode : AddEventEvent()
    data class OpenUrl(val url: String) : AddEventEvent()
}