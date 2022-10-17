package com.psycodeinteractive.fbimostwanted.domain.extension

import com.psycodeinteractive.fbimostwanted.domain.execution.UseCaseExecutor
import com.psycodeinteractive.fbimostwanted.domain.execution.usecase.BaseUseCase
import com.psycodeinteractive.fbimostwanted.domain.execution.usecase.RunningExecution
import io.mockative.Mock
import io.mockative.eq
import io.mockative.given
import io.mockative.mock
import kotlin.test.assertEquals

interface MockCallback : (Any) -> Unit

@Mock val mockRunningExecution = mock(RunningExecution::class)
@Mock val mockCallback = mock(MockCallback::class)

inline fun <reified Result : Any> UseCaseExecutor.givenSuccessfulNoArgumentUseCaseExecution(
    useCase: BaseUseCase<Unit, Result>,
    result: Result
) {
    given(mockCallback)
        .function(mockCallback::invoke)
        .whenInvokedWith(eq(result))
        .then { actualResult ->
            assertEquals(result, actualResult)
        }

    given(this)
        .invocation {
            execute(
                useCase = useCase,
                callback = mockCallback
            )
        }
        .then { arguments ->
            (arguments[1] as MockCallback)(result)
            return@then mockRunningExecution
        }
}
