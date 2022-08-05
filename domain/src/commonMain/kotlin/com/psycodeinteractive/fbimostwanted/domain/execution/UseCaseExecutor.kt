package com.psycodeinteractive.fbimostwanted.domain.execution

import com.psycodeinteractive.fbimostwanted.domain.base.Logger
import com.psycodeinteractive.fbimostwanted.domain.base.exception.DomainException
import com.psycodeinteractive.fbimostwanted.domain.base.usecase.BaseUseCase
import com.psycodeinteractive.fbimostwanted.domain.base.usecase.RunningExecution
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class UseCaseExecutor(
    private var coroutineScope: CoroutineScope,
    private var logger: Logger
) {
    fun <Output> execute(
        useCase: BaseUseCase<Unit, Output>,
        callback: (Output) -> Unit = {},
        onError: (DomainException) -> Unit = {}
    ) = execute(useCase, Unit, callback, onError)

    fun <Input, Output> execute(
        useCase: BaseUseCase<Input, Output>,
        value: Input,
        callback: (Output) -> Unit = {},
        onError: (DomainException) -> Unit = {}
    ): RunningExecution {
        val job = launchUseCaseExecution(useCase, value, callback, onError)
        return RunningUseCaseExecution(job)
    }

    private fun <Input, Output> launchUseCaseExecution(
        useCase: BaseUseCase<Input, Output>,
        value: Input,
        callback: (Output) -> Unit,
        onError: (DomainException) -> Unit
    ) = coroutineScope.launch {
        logger.d("Executing UseCase: ${useCase::class.simpleName} with value: $value")

        try {
            useCase.launchExecution(value, callback)
        } catch (cancellationException: CancellationException) {
            logger.e(cancellationException.cause ?: cancellationException)
        } catch (throwable: Throwable) {
            logger.d(throwable)
            onError(throwable as? DomainException ?: useCase.onError(throwable))
        }
    }

    class RunningUseCaseExecution(private val job: Job) : RunningExecution {
        override fun isRunning() = job.isActive

        override fun cancel() {
            job.cancel()
        }
    }
}
