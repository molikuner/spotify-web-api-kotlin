package com.adamratzman.spotify.utils

import kotlinx.datetime.Instant
import kotlinx.datetime.toNSDate
import platform.Foundation.NSDateFormatter
import kotlin.system.getTimeMillis

actual fun getCurrentTimeMs(): Long = getTimeMillis()

internal actual fun formatDate(format: String, date: Long): String {
    val formatter = NSDateFormatter.alloc()?.apply {
        dateFormat = format
    } ?: throw UnsupportedOperationException("Could not create NSDateFormatter")
    return formatter.stringFromDate(Instant.fromEpochMilliseconds(date).toNSDate())
}
