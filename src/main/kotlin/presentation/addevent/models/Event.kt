package presentation.addevent.models

import domain.models.Coordinates
import java.time.LocalDateTime

data class Event(
    val bannerUrl: String = "",
    val title: String = "",
    val startDate: LocalDateTime = LocalDateTime.now(),
    val endDate: LocalDateTime = LocalDateTime.now(),
    val workingHours: String? = null,
    val address: String = "",
    val coordinates: Coordinates? = null,
    val extraInfo: String? = null,
    val price: String = "",
    val description: String = "",
    val performances: List<Performance> = emptyList()
)
