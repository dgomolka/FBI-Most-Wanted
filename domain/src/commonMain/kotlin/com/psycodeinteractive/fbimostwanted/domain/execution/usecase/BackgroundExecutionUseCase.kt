package com.psycodeinteractive.fbimostwanted.domain.execution.usecase

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext

abstract class BackgroundExecutionUseCase<Input, Output> constructor(
    private val coroutineContextProvider: CoroutineContextProvider
) : BaseUseCase<Input, Output> {
    final override suspend fun launchExecution(value: Input, callback: (Output) -> Unit) {
        val result = withContext(coroutineContextProvider.io) {
            executeInBackground(value, this)
        }

        callback(result)
    }

    abstract suspend fun executeInBackground(
        request: Input,
        coroutineScope: CoroutineScope
    ): Output
}
