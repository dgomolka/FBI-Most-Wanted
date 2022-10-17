package com.psycodeinteractive.fbimostwanted.domain.feature.session.usecase

import com.psycodeinteractive.fbimostwanted.domain.coroutine.testCoroutineContextProvider
import com.psycodeinteractive.fbimostwanted.domain.coroutine.testCoroutineScope
import com.psycodeinteractive.fbimostwanted.domain.feature.session.repository.AppSessionRepository
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.given
import io.mockative.mock
import io.mockative.once
import io.mockative.thenDoNothing
import io.mockative.verify
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test

class StopSessionUseCaseImplTest {

    @Mock
    val appSessionRepository = mock(classOf<AppSessionRepository>())

    private lateinit var classUnderTest: StopSessionUseCaseImpl

    @BeforeTest
    fun setup() {
        classUnderTest = StopSessionUseCaseImpl(appSessionRepository, testCoroutineContextProvider)
    }

    @Test
    fun `When executeInBackground Then verify stopSession was called`() = testCoroutineScope.runTest {
        // Given
        given(appSessionRepository).coroutine { stopSession() }.thenDoNothing()

        // When
        classUnderTest.executeInBackground(Unit, testCoroutineScope)

        // Then
        verify(appSessionRepository).coroutine { stopSession() }.wasInvoked(once)
    }
}
