package com.psycodeinteractive.fbimostwanted.domain.execution.usecase

import com.psycodeinteractive.fbimostwanted.domain.model.exception.DomainException
import com.psycodeinteractive.fbimostwanted.domain.model.exception.UnknownDomainException

interface BaseUseCase<Input, Output> {
    suspend fun launchExecution(value: Input, callback: (Output) -> Unit)

    fun onError(throwable: Throwable): DomainException = UnknownDomainException(throwable)
}
