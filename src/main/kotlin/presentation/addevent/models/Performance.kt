package presentation.addevent.models

import java.time.LocalDateTime

data class Performance(
    val date: LocalDateTime? = null,
    val artist: String,
    val imageUrl: String? = null
)
