package com.psycodeinteractive.fbimostwanted.data.cache

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class Cache<State> {
    private val sharedFlow = MutableSharedFlow<State>(replay = 1)
    val flow: Flow<State> get() = sharedFlow
    private val mutex = Mutex()

    suspend fun emitOnEmpty(onEmpty: suspend () -> State): Cache<State> {
        with(sharedFlow) {
            if (replayCache.isNotEmpty()) return this@Cache
            mutex.withLock {
                val newOnEmpty = onEmpty()
                if (newOnEmpty is Collection<*> && newOnEmpty.isEmpty()) return@withLock
                emit(onEmpty())
            }
        }
        return this
    }

    suspend fun emit(update: suspend (lastState: State?) -> State) {
        mutex.withLock {
            with(sharedFlow) {
                val state = if (replayCache.isNotEmpty()) first() else null
                emit(update(state))
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    suspend fun clear() {
        mutex.withLock {
            sharedFlow.resetReplayCache()
        }
    }
}
