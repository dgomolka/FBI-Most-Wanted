package com.psycodeinteractive.fbimostwanted.ui.contract.mapper

import com.psycodeinteractive.fbimostwanted.presentation.contract.model.PresentationMapperException
import com.psycodeinteractive.fbimostwanted.ui.contract.model.UiMapperException

abstract class PresentationToUiMapper<Input : Any, Output : Any> {
    fun toUi(input: Input): Output = try {
        map(input)
    } catch (throwable: Throwable) {
        throw UiMapperException("Could not map ${input::class.simpleName}", throwable)
    }

    protected abstract fun map(input: Input): Output
}

abstract class UiToPresentationMapper<Input : Any, Output : Any> {
    fun toPresentation(input: Input): Output = try {
        map(input)
    } catch (throwable: Throwable) {
        throw PresentationMapperException("Could not map ${input::class.simpleName}", throwable)
    }

    protected abstract fun map(input: Input): Output
}
