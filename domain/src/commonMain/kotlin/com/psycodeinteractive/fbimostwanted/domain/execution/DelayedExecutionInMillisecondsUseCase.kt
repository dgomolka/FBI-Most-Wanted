package com.psycodeinteractive.fbimostwanted.domain.execution

import com.psycodeinteractive.fbimostwanted.domain.base.usecase.BackgroundExecutionUseCase
import com.psycodeinteractive.fbimostwanted.domain.base.usecase.BaseUseCase
import com.psycodeinteractive.fbimostwanted.domain.base.usecase.PlatformCoroutineContextProvider
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
