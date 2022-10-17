package com.psycodeinteractive.fbimostwanted.domain.coroutine

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlin.coroutines.CoroutineContext

@OptIn(ExperimentalCoroutinesApi::class)
private class TestCoroutineContextProvider(
    override val main: CoroutineContext = testCoroutineScope.coroutineContext,
    override val io: CoroutineContext = testCoroutineScope.coroutineContext
) : CoroutineContextProvider

val testCoroutineContextProvider: CoroutineContextProvider =
    TestCoroutineContextProvider()
