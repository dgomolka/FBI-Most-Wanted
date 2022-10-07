package com.psycodeinteractive.fbimostwanted.domain.execution

import com.psycodeinteractive.fbimostwanted.domain.coroutine.PlatformCoroutineContextProvider
import com.psycodeinteractive.fbimostwanted.domain.execution.usecase.BackgroundExecutionUseCase
import com.psycodeinteractive.fbimostwanted.domain.execution.usecase.BaseUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay

interface DelayedExecutionInMillisecondsUseCase : BaseUseCase<Long, Unit>

class DelayedExecutionInMillisecondsUseCaseImpl(
    coroutineContextProvider: PlatformCoroutineContextProvider
) : BackgroundExecutionUseCase<Long, Unit>(coroutineContextProvider), DelayedExecutionInMillisecondsUseCase {
    override suspend fun executeInBackground(request: Long, coroutineScope: CoroutineScope) {
        delay(request)
    }
}
