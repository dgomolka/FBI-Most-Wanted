package com.psycodeinteractive.fbimostwanted.domain.base.usecase

import com.psycodeinteractive.fbimostwanted.domain.base.exception.DomainException
import com.psycodeinteractive.fbimostwanted.domain.base.exception.UnknownDomainException

interface BaseUseCase<Input, Output> {
    suspend fun launchExecution(value: Input, callback: (Output) -> Unit)

    fun onError(throwable: Throwable): DomainException = UnknownDomainException(throwable)
}
