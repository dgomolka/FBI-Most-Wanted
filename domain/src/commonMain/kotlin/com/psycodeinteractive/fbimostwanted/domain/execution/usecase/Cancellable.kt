package com.psycodeinteractive.fbimostwanted.domain.execution.usecase

interface Cancellable {
    fun cancel()
}

interface RunningExecution : Cancellable {
    fun isRunning(): Boolean
}
