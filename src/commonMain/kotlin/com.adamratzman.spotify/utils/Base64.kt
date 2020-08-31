/* Spotify Web API, Kotlin Wrapper; MIT License, 2017-2020; Original author: Adam Ratzman */
package com.adamratzman.spotify.utils

import io.ktor.utils.io.core.String
import io.ktor.utils.io.core.toByteArray

private const val BASE64_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
private const val BASE64_MASK = 0x3f
private const val BASE64_PAD = '='

private fun Int.toBase64(): Char = BASE64_ALPHABET[this]

fun encodeToBase64(src: ByteArray): ByteArray {
    fun ByteArray.getOrZero(index: Int): Int = if (index >= size) 0 else get(index).toInt()
    // 4n / 3 is expected Base64 payload
    val result = ArrayList<Byte>(4 * src.size / 3)
    var index = 0
    while (index < src.size) {
        val symbolsLeft = src.size - index
        val padSize = if (symbolsLeft >= 3) 0 else (3 - symbolsLeft) * 8 / 6
        val chunk = (src.getOrZero(index) shl 16) or (src.getOrZero(index + 1) shl 8) or src.getOrZero(index + 2)
        index += 3

        for (i in 3 downTo padSize) {
            val char = (chunk shr (6 * i)) and BASE64_MASK
            result.add(char.toBase64().toByte())
        }
        // Fill the pad with '='
        repeat(padSize) { result.add(BASE64_PAD.toByte()) }
    }

    return result.toByteArray()
}

fun String.encodeToBase64() = String(encodeToBase64(toByteArray()))
