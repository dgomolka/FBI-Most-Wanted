package com.psycodeinteractive.fbimostwanted.presentation.mapper

import com.psycodeinteractive.fbimostwanted.domain.model.exception.DomainException
import com.psycodeinteractive.fbimostwanted.domain.model.exception.UnknownDomainException
import com.psycodeinteractive.fbimostwanted.presentation.contract.mapper.DomainToPresentationMapper
import com.psycodeinteractive.fbimostwanted.presentation.model.exception.PresentationException
import com.psycodeinteractive.fbimostwanted.presentation.model.exception.UnknownPresentationException

class DefaultDomainToPresentationExceptionMapper :
    DomainToPresentationMapper<DomainException, PresentationException>() {
    override fun map(input: DomainException) = when (input) {
        is UnknownDomainException -> UnknownPresentationException(input)
        else -> UnknownPresentationException(input)
    }
}
