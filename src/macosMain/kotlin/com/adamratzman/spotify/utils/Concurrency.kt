package com.adamratzman.spotify.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking

actual enum class TimeUnit(val multiplier: Long) {
    MILLISECONDS(1), SECONDS(1000);

    actual fun toMillis(duration: Long): Long = duration * multiplier
}

actual inline fun <T> runBlockingMpp(noinline block: suspend CoroutineScope.() -> T): T = runBlocking(block = block)
