/* Spotify Web API, Kotlin Wrapper; MIT License, 2017-2020; Original author: Adam Ratzman */
package com.adamratzman.spotify.utils

import com.adamratzman.spotify.SpotifyRestAction
import java9.util.concurrent.CompletableFuture
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking

actual inline fun <T> runBlockingMpp(noinline block: suspend CoroutineScope.() -> T): T = runBlocking(block = block)

actual typealias TimeUnit = java.util.concurrent.TimeUnit

/**
 * Return this [SpotifyRestAction] as a normal [CompletableFuture]
 */
fun <T> SpotifyRestAction<T>.asFuture(): CompletableFuture<T> = CompletableFuture.supplyAsync(::complete)
