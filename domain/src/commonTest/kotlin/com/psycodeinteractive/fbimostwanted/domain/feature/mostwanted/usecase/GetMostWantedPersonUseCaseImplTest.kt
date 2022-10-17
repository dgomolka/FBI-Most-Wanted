package com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.usecase

import com.psycodeinteractive.fbimostwanted.domain.coroutine.testCoroutineContextProvider
import com.psycodeinteractive.fbimostwanted.domain.coroutine.testCoroutineScope
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.givenMostWantedPerson1
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.repository.MostWantedRepository
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.given
import io.mockative.mock
import io.mockative.once
import io.mockative.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class GetMostWantedPersonUseCaseImplTest {

    @Mock
    val mostWantedRepository = mock(classOf<MostWantedRepository>())

    private lateinit var classUnderTest: GetMostWantedPersonUseCaseImpl

    @BeforeTest
    fun setup() {
        classUnderTest = GetMostWantedPersonUseCaseImpl(mostWantedRepository, testCoroutineContextProvider)
    }

    @Test
    fun `Given person id When executeInBackground Then verify most wanted person was requested and returned`() = testCoroutineScope.runTest {
        // Given
        val givenMostWantedPerson = givenMostWantedPerson1
        val givenId = givenMostWantedPerson.id
        given(mostWantedRepository).coroutine { getMostWantedPerson(givenId) }.thenReturn(givenMostWantedPerson)

        // When
        val actualResult = classUnderTest.executeInBackground(givenId, testCoroutineScope)

        // Then
        verify(mostWantedRepository).coroutine { getMostWantedPerson(givenId) }.wasInvoked(once)
        assertEquals(givenMostWantedPerson, actualResult)
    }
}
