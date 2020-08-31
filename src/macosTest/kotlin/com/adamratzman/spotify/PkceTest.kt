/* Spotify Web API, Kotlin Wrapper; MIT License, 2017-2020; Original author: Adam Ratzman */
package com.adamratzman.spotify

import kotlin.test.Test
import kotlin.test.assertEquals

class PkceTest {

    @Test
    fun `should encode pkce code challenge correctly`() {
        val input = "hello, world!"

        val output = getSpotifyPkceCodeChallenge(input)

        assertEquals(
            "abc",
            output
        )
    }
}
