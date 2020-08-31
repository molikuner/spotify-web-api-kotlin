package com.adamratzman.spotify

import com.adamratzman.spotify.utils.encodeToBase64
import kotlinx.cinterop.UByteVar
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.cstr
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.readBytes
import kotlinx.cinterop.toKString
import kotlinx.cinterop.usePinned
import platform.CoreCrypto.CC_SHA256
import platform.CoreCrypto.CC_SHA256_DIGEST_LENGTH

class HashCreationException: SpotifyException.UnNullableException("Could not create hash via OpenSSL")

actual fun getSpotifyPkceCodeChallenge(codeVerifier: String): String {
    val sha = memScoped {
        allocArray<UByteVar>(CC_SHA256_DIGEST_LENGTH).usePinned { sha ->
            CC_SHA256(codeVerifier.cstr, codeVerifier.encodeToByteArray().size.toUInt(), sha.get())
        }
            ?.readBytes(CC_SHA256_DIGEST_LENGTH) // ?.reinterpret<ByteVar>()
            ?.toKString()
            ?: throw HashCreationException()
    }

    return sha.encodeToBase64()
}
