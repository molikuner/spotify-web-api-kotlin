/* Spotify Web API, Kotlin Wrapper; MIT License, 2017-2020; Original author: Adam Ratzman */
package com.adamratzman.spotify.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

actual inline fun <T> runBlockingMpp(noinline block: suspend CoroutineScope.() -> T): dynamic {
    return GlobalScope.promise(block = block)
}

actual enum class TimeUnit(val multiplier: Int) {
    MILLISECONDS(1), SECONDS(1000), MINUTES(60000);

    actual fun toMillis(duration: Long) = duration * multiplier
}
