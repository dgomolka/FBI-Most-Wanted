package com.psycodeinteractive.fbimostwanted.domain.base.usecase

import kotlin.coroutines.CoroutineContext

interface CoroutineContextProvider {
    val main: CoroutineContext
    val io: CoroutineContext
}

expect class PlatformCoroutineContextProvider : CoroutineContextProvider
