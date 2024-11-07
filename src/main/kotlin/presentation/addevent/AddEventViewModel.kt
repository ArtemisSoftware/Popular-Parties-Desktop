package presentation.addevent

import domain.usecases.GetEventDataFromHtmlUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class AddEventViewModel(
    private val getEventDataFromHtmlUseCase: GetEventDataFromHtmlUseCase = GetEventDataFromHtmlUseCase()
) {

    private val _state = MutableStateFlow(AddEventState())
    val state: StateFlow<AddEventState> = _state.asStateFlow()

    fun onTriggerEvent(event: AddEventEvent) {
        when (event) {
            is AddEventEvent.OpenUrl -> TODO()
            AddEventEvent.Search -> fetchHtmlWithOkHttp()
            is AddEventEvent.UpdateSearchQuery -> updateSearchText(event.query)
            AddEventEvent.ToggleHtmlCode -> toggleHtmlCode()
        }
    }

    private fun updateSearchText(text: String) = with(_state) {
        update {
            it.copy(url = text)
        }
    }

    private fun toggleHtmlCode() = with(_state) {
        update {
            it.copy(showHtmlCode = !it.showHtmlCode)
        }
    }

    private fun openUrl(url: String) {
        if (!url.isNullOrEmpty()) {
            //openURL(url)
        }
    }

    val client = OkHttpClient()
    private fun fetchHtmlWithOkHttp() = with(_state) {
        val request = Request.Builder().url(_state.value.url).build()
        client.newCall(request).execute().use { response ->

            if (!response.isSuccessful) {
                throw IOException("Unexpected code $response")
            } else{


                val htmlContent = response.body!!.string()
                val event = getEventDataFromHtmlUseCase(htmlContent)

                update {
                    it.copy(
                        htmlContent = htmlContent,
                        event = event
                    )
                }
            }
        }
    }
}