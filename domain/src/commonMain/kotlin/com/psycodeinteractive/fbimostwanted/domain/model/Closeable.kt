package com.psycodeinteractive.fbimostwanted.domain.model

interface Closeable {
    fun close()
    fun tryClose() {
        try {
            close()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}
