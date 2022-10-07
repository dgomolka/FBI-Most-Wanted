package com.psycodeinteractive.fbimostwanted.presentation.model.exception

abstract class PresentationException(open val throwable: Throwable) : Exception(throwable) {
    constructor(message: String) : this(Exception(message))
}
