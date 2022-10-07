package com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.usecase

import com.psycodeinteractive.fbimostwanted.domain.coroutine.CoroutineContextProvider
import com.psycodeinteractive.fbimostwanted.domain.coroutine.fakeCoroutineContextProvider
import com.psycodeinteractive.fbimostwanted.domain.coroutine.fakeCoroutineScope
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.givenMostWantedPerson1
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.repository.MostWantedRepository
import io.mockative.Mock
import io.mockative.Times
import io.mockative.classOf
import io.mockative.given
import io.mockative.mock
import io.mockative.verify
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class GetMostWantedPersonUseCaseImplTest {

    @Mock
    val mostWantedRepository = mock(classOf<MostWantedRepository>())

    private lateinit var classUnderTest: GetMostWantedPersonUseCaseImpl

    private lateinit var coroutineContextProvider: CoroutineContextProvider

    private lateinit var coroutineScope: CoroutineScope

    @BeforeTest
    fun setup() {
        coroutineContextProvider = fakeCoroutineContextProvider
        coroutineScope = fakeCoroutineScope
        classUnderTest = GetMostWantedPersonUseCaseImpl(mostWantedRepository, coroutineContextProvider)
    }

    @Test
    fun `Given person id When executeInBackground Then verify most wanted person was requested and returned`() = runBlocking {
        // Given
        val givenMostWantedPerson = givenMostWantedPerson1
        val givenId = givenMostWantedPerson.id
        given(mostWantedRepository).coroutine { getMostWantedPerson(givenId) }.thenReturn(givenMostWantedPerson)

        // When
        val actualResult = classUnderTest.executeInBackground(givenId, coroutineScope)

        // Then
        verify(mostWantedRepository).coroutine { getMostWantedPerson(givenId) }.wasInvoked(Times(1))
        assertEquals(givenMostWantedPerson, actualResult)
    }
}
