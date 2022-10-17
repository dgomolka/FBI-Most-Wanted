package com.psycodeinteractive.fbimostwanted.presentation.feature.splash

import com.psycodeinteractive.fbimostwanted.domain.execution.UseCaseExecutor
import com.psycodeinteractive.fbimostwanted.domain.execution.usecase.BackgroundExecutionUseCase
import com.psycodeinteractive.fbimostwanted.domain.execution.usecase.RunningExecution
import com.psycodeinteractive.fbimostwanted.presentation.TestBaseViewModel
import com.psycodeinteractive.fbimostwanted.presentation.execution.TestBackgroundUseCase
import com.psycodeinteractive.fbimostwanted.presentation.mapper.DefaultDomainToPresentationExceptionMapper
import io.mockative.Mock
import io.mockative.any
import io.mockative.classOf
import io.mockative.given
import io.mockative.mock
import kotlinx.coroutines.runBlocking
import kotlin.test.BeforeTest
import kotlin.test.Test

class SplashViewModelTest {

    @Mock
    val defaultDomainToPresentationExceptionMapper = mock(classOf<DefaultDomainToPresentationExceptionMapper>())
//
//    @Mock
//    val testBackgroundExecutionUseCase = mock(classOf<TestBackgroundUseCase>())
//
//    @Mock
//    val useCaseExecutor = mock(classOf<UseCaseExecutor>())
//
//    private lateinit var classUnderTest: SplashViewModel
//
//    @BeforeTest
//    fun setup() {
//        classUnderTest = SplashViewModel(
//            useCaseExecutorProvider = useCaseExecutor,
//            defaultDomainToPresentationExceptionMapper = defaultDomainToPresentationExceptionMapper
//        )
//    }
//
//    @Test
//    fun `Given successful use case execution invoke Unit`() {
//        runBlocking {
//            // Given
//            given(testBackgroundExecutionUseCase)
//                .function(testBackgroundExecutionUseCase)
//                .whenInvokedWith(any<BackgroundExecutionUseCase<Any, Any>>(), any<Any>(), any<Any>(), any<Any>())
//                .thenReturn()
//
//            // When
//            val actualResult = testBackgroundExecutionUseCase.
//
//                // Then
//            verify(classUnderTest)
//                .invocation {
//                    any<BackgroundExecutionUseCase<Any, Any>>().
//                }
//        }
//    }
}
