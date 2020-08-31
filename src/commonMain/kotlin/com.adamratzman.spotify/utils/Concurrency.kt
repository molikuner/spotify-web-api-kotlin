/* Spotify Web API, Kotlin Wrapper; MIT License, 2017-2020; Original author: Adam Ratzman */
package com.adamratzman.spotify.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

expect enum class TimeUnit {
    MILLISECONDS, SECONDS;

    fun toMillis(duration: Long): Long
}

internal fun CoroutineScope.schedule(quantity: Int, timeUnit: TimeUnit, consumer: () -> Unit) = launch {
    delay(timeUnit.toMillis(quantity.toLong()))
    consumer()
}

expect fun <T> runBlockingMpp(block: suspend CoroutineScope.() -> T): T
