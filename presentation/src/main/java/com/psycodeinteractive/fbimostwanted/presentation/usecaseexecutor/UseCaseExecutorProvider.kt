package com.psycodeinteractive.fbimostwanted.presentation.usecaseexecutor

import com.psycodeinteractive.fbimostwanted.domain.execution.UseCaseExecutor
import kotlinx.coroutines.CoroutineScope

typealias UseCaseExecutorProvider = (coroutineScope: CoroutineScope) -> UseCaseExecutor
