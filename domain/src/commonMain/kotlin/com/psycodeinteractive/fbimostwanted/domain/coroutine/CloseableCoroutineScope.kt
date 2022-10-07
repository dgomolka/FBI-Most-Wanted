package com.psycodeinteractive.fbimostwanted.domain.coroutine

import com.psycodeinteractive.fbimostwanted.domain.model.Closeable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

class CloseableCoroutineScope(
    context: CoroutineContext
) : CoroutineScope, Closeable {
  
    override val coroutineContext: CoroutineContext = context
  
    override fun close() {
        coroutineContext.cancel()
    }
}
