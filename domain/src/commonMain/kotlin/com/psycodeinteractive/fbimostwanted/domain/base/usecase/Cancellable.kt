package com.psycodeinteractive.fbimostwanted.domain.base.usecase

interface Cancellable {
    fun cancel()
}

interface RunningExecution : Cancellable {
    fun isRunning(): Boolean
}
