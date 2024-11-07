package domain.util.extensions

import domain.util.constants.TimeConstants
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

fun String.toLocalDateTime(format: String = TimeConstants.FORMAT_DD_MM_YYYY): LocalDateTime {
    val formatter = DateTimeFormatter.ofPattern(format)
    val date = LocalDate.parse(this, formatter)
    return date.atStartOfDay()
}

fun LocalDateTime.format(pattern: String = TimeConstants.FORMAT_DD_MM_YYYY): String {
    val formatter = DateTimeFormatter.ofPattern(pattern)
    return this.format(formatter)
}

fun String.toEnglishLocalDateTime(year: Int): LocalDateTime? {
    val monthsInPortuguese = mapOf(
        "janeiro" to "January",
        "fevereiro" to "February",
        "março" to "March",
        "abril" to "April",
        "maio" to "May",
        "junho" to "June",
        "julho" to "July",
        "agosto" to "August",
        "setembro" to "September",
        "outubro" to "October",
        "novembro" to "November",
        "dezembro" to "December"
    )

    // Extract day, month, and time from the string
    val regex = """(\d{1,2}) de (\w+),.*?(\d{2}:\d{2})""".toRegex()
    val matchResult = regex.find(this) ?: return null

    val (day, monthInPortuguese, time) = matchResult.destructured
    val monthInEnglish = monthsInPortuguese[monthInPortuguese] ?: return null

    // Define the formatter for parsing day-month-time
    val formatter = DateTimeFormatter.ofPattern(TimeConstants.FORMAT_D_MMMM_YYYY_HH_MM, Locale.ENGLISH)

    // Parse the date and time into LocalDateTime
    val dateTimeString = "$day $monthInEnglish $year $time"
    return LocalDateTime.parse(dateTimeString, formatter)
}
