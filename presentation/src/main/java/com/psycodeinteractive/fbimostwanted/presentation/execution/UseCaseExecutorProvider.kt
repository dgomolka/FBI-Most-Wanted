package com.psycodeinteractive.fbimostwanted.presentation.execution

import com.psycodeinteractive.fbimostwanted.domain.execution.UseCaseExecutor
import kotlinx.coroutines.CoroutineScope

interface UseCaseExecutorProvider {
    operator fun invoke(coroutineScope: CoroutineScope): UseCaseExecutor
}
//typealias UseCaseExecutorProvider = (coroutineScope: CoroutineScope) -> UseCaseExecutor
