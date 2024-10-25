package presentation.util

import java.awt.Desktop
import java.net.URI

object UrlUtil{
    fun openUrl(url: String) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(URI(url))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {
            println("Desktop is not supported on this platform.")
        }
    }
}