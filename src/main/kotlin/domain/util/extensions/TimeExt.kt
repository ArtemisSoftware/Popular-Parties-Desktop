package domain.util.extensions

import domain.util.constants.TimeConstants
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun String.toLocalDateTime(format: String = TimeConstants.FORMAT_DD_MM_YYYY): LocalDateTime {
    val formatter = DateTimeFormatter.ofPattern(format)
    val date = LocalDate.parse(this, formatter)
    return date.atStartOfDay()
}

fun LocalDateTime.format(pattern: String = TimeConstants.FORMAT_DD_MM_YYYY): String {
    val formatter = DateTimeFormatter.ofPattern(pattern)
    return this.format(formatter)
}