package com.psycodeinteractive.fbimostwanted.domain.execution

import com.psycodeinteractive.fbimostwanted.domain.execution.usecase.BaseUseCase
import com.psycodeinteractive.fbimostwanted.domain.execution.usecase.RunningExecution
import com.psycodeinteractive.fbimostwanted.domain.logger.Logger
import com.psycodeinteractive.fbimostwanted.domain.model.exception.DomainException
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
            cancellationException.printStackTrace()
            logger.e(cancellationException.cause ?: cancellationException)
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
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
