package com.psycodeinteractive.fbimostwanted.presentation

import com.psycodeinteractive.fbimostwanted.domain.coroutine.CloseableCoroutineScope
import com.psycodeinteractive.fbimostwanted.domain.model.Closeable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.SupervisorJob

actual abstract class SharedViewModel {
    private var hasCleared = false

    actual val viewModelScope: CoroutineScope by lazy {
        CloseableCoroutineScope(SupervisorJob() + Main.immediate).apply {
            if (hasCleared) {
                tryClose()
            }
        }
    }

    protected actual open fun onCleared() {}

    /**
     * Closes the [viewModelScope] and cancels all its coroutines.
     * Should be called from main thread.
     */
    fun clear() {
        hasCleared = true
        (viewModelScope as Closeable).tryClose()
        onCleared()
    }
}
