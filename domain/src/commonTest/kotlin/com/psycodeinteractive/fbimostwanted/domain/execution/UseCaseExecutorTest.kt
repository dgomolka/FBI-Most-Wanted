package com.psycodeinteractive.fbimostwanted.domain.execution

import com.psycodeinteractive.fbimostwanted.domain.coroutine.testCoroutineScope
import com.psycodeinteractive.fbimostwanted.domain.execution.usecase.BaseUseCase
import com.psycodeinteractive.fbimostwanted.domain.logger.Logger
import io.mockative.Mock
import io.mockative.eq
import io.mockative.given
import io.mockative.mock
import io.mockative.once
import io.mockative.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class UseCaseExecutorTest {

    @Mock
    val logger = mock(Logger::class)

    @Mock
    val mockCallback = mock(MockCallback::class)

    @Mock
    val testUseCase = mock(TestUseCase::class)

    private lateinit var classUnderTest: UseCaseExecutor

    @BeforeTest
    fun setup() {
        classUnderTest = UseCaseExecutor(testCoroutineScope, logger)
    }

    @Test
    fun `Given successful use case execution invoke callback`() {
        testCoroutineScope.runTest {
            // Given
            val expectedCallbackResult = ""
            given(mockCallback)
                .function(mockCallback::invoke)
                .whenInvokedWith(eq(expectedCallbackResult))
                .then { actualResult ->
                    assertEquals(expectedCallbackResult, actualResult)
                }

            given(testUseCase)
                .suspendFunction(testUseCase::launchExecution)
                .whenInvokedWith(eq(Unit), eq(mockCallback))
                .then { _, callback ->
                    callback("")
                }

            // When
            classUnderTest.execute(testUseCase, mockCallback)
            advanceUntilIdle()

            // Then
            verify(testUseCase)
                .function(testUseCase::launchExecution)
                .with(eq(Unit), eq(mockCallback))
                .wasInvoked(once)

            verify(mockCallback)
                .function(mockCallback::invoke)
                .with(eq(expectedCallbackResult))
                .wasInvoked(once)
        }
    }

    interface MockCallback : (String) -> Unit
    interface TestUseCase : BaseUseCase<Unit, String>
}

