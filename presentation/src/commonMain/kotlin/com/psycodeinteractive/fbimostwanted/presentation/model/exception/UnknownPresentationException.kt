package com.psycodeinteractive.fbimostwanted.presentation.model.exception

data class UnknownPresentationException(override val throwable: Throwable) : PresentationException(throwable) {
    constructor(errorMessage: String) : this(Throwable(errorMessage))
}
