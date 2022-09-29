package com.psycodeinteractive.fbimostwanted.domain.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

private class FakeCoroutineScope : CoroutineScope {
    override val coroutineContext: CoroutineContext = fakeCoroutineContext
}

val fakeCoroutineScope: CoroutineScope = FakeCoroutineScope()
