package com.adamratzman.spotify.utils

import platform.posix.__sFILE

actual typealias File = __sFILE

actual typealias BufferedImage = __sFILE

actual typealias ConcurrentHashMap<K, V> = HashMap<K, V>

actual fun <K, V> ConcurrentHashMap<K, V>.asList(): List<Pair<K, V>> = toList()
