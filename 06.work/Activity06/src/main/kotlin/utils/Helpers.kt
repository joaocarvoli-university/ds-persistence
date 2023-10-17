package utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object Helpers {
    fun getCurrentTime(): String? {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        return LocalDateTime.now().format(formatter)
    }
}