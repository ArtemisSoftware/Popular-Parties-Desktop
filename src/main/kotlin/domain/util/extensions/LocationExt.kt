package domain.util.extensions

fun String.convertDmsToDecimal(): Double? {
    // Parse the DMS format using a regex pattern
    //val regex = Regex("""(\d+)[°](\d+)'(\d+.\d+)"([NSEW])""")
    val regex = Regex("""(\d+)[°](\d+)'(\d+(?:\.\d+)?)?"?([NSEW])""")
    val matchResult = regex.find(this) ?: return null

    val (degrees, minutes, seconds, direction) = matchResult.destructured

    // Calculate decimal value
    val decimal = degrees.toDouble() + (minutes.toDouble() / 60) + (seconds.toDouble() / 3600)
    return if (direction == "S" || direction == "W") -decimal else decimal
}