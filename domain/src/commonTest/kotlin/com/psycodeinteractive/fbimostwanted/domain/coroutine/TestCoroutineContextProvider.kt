package com.psycodeinteractive.fbimostwanted.domain.coroutine

import kotlin.coroutines.CoroutineContext

private class TestCoroutineContextProvider(
    override val main: CoroutineContext = testCoroutineScope.coroutineContext,
    override val io: CoroutineContext = testCoroutineScope.coroutineContext
) : CoroutineContextProvider

val testCoroutineContextProvider: CoroutineContextProvider =
    TestCoroutineContextProvider()
