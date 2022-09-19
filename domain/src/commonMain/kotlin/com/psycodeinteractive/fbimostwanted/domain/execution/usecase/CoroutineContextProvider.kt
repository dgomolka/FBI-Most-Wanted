package com.psycodeinteractive.fbimostwanted.domain.execution.usecase

import kotlin.coroutines.CoroutineContext

interface CoroutineContextProvider {
    val main: CoroutineContext
    val io: CoroutineContext
}

expect object PlatformCoroutineContextProvider : CoroutineContextProvider
