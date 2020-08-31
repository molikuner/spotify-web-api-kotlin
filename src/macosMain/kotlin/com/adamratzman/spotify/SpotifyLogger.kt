package com.adamratzman.spotify

import platform.posix.fprintf
import platform.posix.stderr

actual class SpotifyLogger actual constructor(actual var enabled: Boolean) {

    actual fun logInfo(message: String) {
        if (enabled) println(message)
    }

    actual fun logWarning(message: String) {
        if (enabled) println("Warning: $message")
    }

    actual fun logError(fatal: Boolean, message: String?, throwable: Throwable?) {
        if (!enabled) return

        val error = StringBuilder("Spotify Logger ").apply {
            if (fatal) append("FATAL")
            else append("Error")
            if (message != null) {
                append(": ")
                append(message)
            }
            append("\n")
            append(throwable)
        }.toString()
        fprintf(stderr, error)
    }

}
