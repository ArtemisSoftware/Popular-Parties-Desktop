package domain.usecases

import domain.models.Coordinates
import domain.util.extensions.convertDmsToDecimal
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import presentation.addevent.models.Event
import domain.util.extensions.toLocalDateTime
import java.time.LocalDateTime

class GetEventDataFromHtmlUseCase {

    operator fun invoke(htmlContent: String): Event {

        val document: Document = Jsoup.parse(htmlContent)
        val dates = getDate(document)

        return Event(
            title = getTitle(document),
            startDate = dates.first,
            endDate = dates.second,
            workingHours = getWorkingHours(document),
            address = getAddress(document),
            coordinates = getGpsCoordinates(document),
            extraInfo = getExtraInfo(document),
            price = getPrice(document),
            description = getDescription(document)
        )
    }

    private fun getTitle(document: Document): String {
        val title = document.title()
        return title
    }

    private fun getDate(document: Document): Pair<LocalDateTime, LocalDateTime> {
        val date = document.select("div.dateinfo").text()
        val result = date.split(" ").toMutableList()

        if(result.size == 3) result.removeAt(1)

        return Pair(result.first().toLocalDateTime(), result.last().toLocalDateTime())
    }

    private fun getWorkingHours(document: Document): String? {
        val workingHours = document.select("div.days-single-event").first()
        return workingHours?.text()?.trim()
    }

    private fun getAddress(document: Document): String {
        val result = document.select("#address").text()
        return result
    }

    private fun getGpsCoordinates(document: Document): Coordinates? {
        val latitude = document.select("span#lat").text().convertDmsToDecimal()
        val longitude = document.select("span#long").text().convertDmsToDecimal()

        if (latitude == null || longitude == null) return null
        return Coordinates(latitude, longitude)
    }

    private fun getExtraInfo(document: Document): String? {
        val extraInfo = document.select("div.extra > div").firstOrNull()
        return extraInfo?.ownText()?.removePrefix("Informação Extra: ")?.trim()
    }

    private fun getPrice(document: Document): String {
        val price = document.select("div.price-single-event div.event_price").firstOrNull()
        return price?.text()?.trim() ?: "0 €"
    }

    private fun getDescription(document: Document): String {
        val description = document.select("div.event-des p strong").text()
        return description
    }
}