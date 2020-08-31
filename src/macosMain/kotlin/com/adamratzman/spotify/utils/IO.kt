package com.adamratzman.spotify.utils

internal actual fun convertFileToBufferedImage(file: File): BufferedImage = file
internal actual fun convertUrlPathToBufferedImage(url: String): BufferedImage =
    throw NotImplementedError("Images not implemented yet.")
internal actual fun convertLocalImagePathToBufferedImage(path: String): BufferedImage =
    throw NotImplementedError("Images not implemented yet.")
internal actual fun encodeBufferedImageToBase64String(image: BufferedImage): String =
    throw NotImplementedError("Images not implemented yet.")
