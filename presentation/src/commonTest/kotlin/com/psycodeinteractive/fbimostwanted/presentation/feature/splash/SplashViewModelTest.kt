package com.psycodeinteractive.fbimostwanted.presentation.feature.splash

import com.psycodeinteractive.fbimostwanted.domain.execution.UseCaseExecutor
import com.psycodeinteractive.fbimostwanted.domain.logger.Logger
import com.psycodeinteractive.fbimostwanted.presentation.coroutine.testCoroutineScope
import com.psycodeinteractive.fbimostwanted.presentation.execution.UseCaseExecutorProvider
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedlist.MostWantedListPresentationDestination
import com.psycodeinteractive.fbimostwanted.presentation.mapper.DefaultDomainToPresentationExceptionMapper
import io.mockative.Mock
import io.mockative.mock
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class SplashViewModelTest {

    @Mock
    val useCaseExecutor = mock(UseCaseExecutor::class)

    @Mock
    val defaultDomainToPresentationExceptionMapper = mock(DefaultDomainToPresentationExceptionMapper::class)

    @Mock
    val logger = mock(Logger::class)

    private lateinit var classUnderTest: SplashViewModel

    @BeforeTest
    fun setup() {
        val useCaseExecutorProvider = object : UseCaseExecutorProvider {
            override fun invoke(coroutineScope: CoroutineScope) = useCaseExecutor
        }
        classUnderTest = SplashViewModel(
            useCaseExecutorProvider = useCaseExecutorProvider,
            defaultDomainToPresentationExceptionMapper = defaultDomainToPresentationExceptionMapper,
            logger = logger
        )
    }

    @Test
    fun `When onViewCreated then verify StartSplash event was sent`() = testCoroutineScope.runTest {
        // Given
        val expectedEvent = SplashEvent.StartSplash

        // When
        classUnderTest.onViewCreated()

        // Then
        val actualEvent = classUnderTest.eventFlow.first()
        assertEquals(expectedEvent, actualEvent)
    }

    @Test
    fun `When onSplashFinished then verify MostWantedList navigation command was sent`() = testCoroutineScope.runTest {
        // Given
        val expectedNavigationCommand = MostWantedListPresentationDestination

        // When
        classUnderTest.onSplashFinished()

        // Then
        val actualNavigationCommand = classUnderTest.navigationCommands.first()
        assertEquals(expectedNavigationCommand, actualNavigationCommand)
    }
}
