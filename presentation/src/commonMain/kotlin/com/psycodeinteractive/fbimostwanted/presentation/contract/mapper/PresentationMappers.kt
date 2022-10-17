package com.psycodeinteractive.fbimostwanted.presentation.contract.mapper

import com.psycodeinteractive.fbimostwanted.domain.contract.model.DomainMapperException
import com.psycodeinteractive.fbimostwanted.presentation.contract.model.PresentationMapperException

interface DomainToPresentationMapper<Input : Any, Output : Any> {
    fun toPresentation(input: Input): Output = try {
        map(input)
    } catch (throwable: Throwable) {
        throw PresentationMapperException("Could not map ${input::class.simpleName}", throwable)
    }

    fun map(input: Input): Output
}

abstract class PresentationToDomainMapper<Input : Any, Output : Any> {
    fun toDomain(input: Input): Output = try {
        map(input)
    } catch (throwable: Throwable) {
        throw DomainMapperException("Could not map ${input::class.simpleName}", throwable)
    }

    protected abstract fun map(input: Input): Output
}
