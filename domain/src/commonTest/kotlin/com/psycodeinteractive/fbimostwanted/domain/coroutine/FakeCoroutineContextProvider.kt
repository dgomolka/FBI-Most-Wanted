package com.psycodeinteractive.fbimostwanted.domain.coroutine

import com.psycodeinteractive.fbimostwanted.domain.execution.usecase.CoroutineContextProvider
import kotlin.coroutines.CoroutineContext

private class FakeCoroutineContextProvider(
    override val main: CoroutineContext = fakeCoroutineContext,
    override val io: CoroutineContext = fakeCoroutineContext
) : CoroutineContextProvider

val fakeCoroutineContextProvider: CoroutineContextProvider =
    FakeCoroutineContextProvider()
