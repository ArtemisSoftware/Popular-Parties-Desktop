package presentation.addevent

import presentation.addevent.models.Event

data class AddEventState(
    val url: String = "",
    val isLoading: Boolean = false,
    val htmlContent: String = "",
    val showHtmlCode: Boolean = false,
    val event: Event = Event()
)
