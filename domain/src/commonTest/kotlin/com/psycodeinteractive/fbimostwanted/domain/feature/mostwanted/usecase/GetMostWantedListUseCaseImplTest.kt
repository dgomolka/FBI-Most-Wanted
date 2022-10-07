package com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.usecase

import com.psycodeinteractive.fbimostwanted.domain.coroutine.CoroutineContextProvider
import com.psycodeinteractive.fbimostwanted.domain.coroutine.fakeCoroutineContextProvider
import com.psycodeinteractive.fbimostwanted.domain.coroutine.fakeCoroutineScope
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.givenMostWantedList
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

class GetMostWantedListUseCaseImplTest {

    @Mock
    val mostWantedRepository = mock(classOf<MostWantedRepository>())

    private lateinit var classUnderTest: GetMostWantedListUseCaseImpl

    private lateinit var coroutineContextProvider: CoroutineContextProvider

    private lateinit var coroutineScope: CoroutineScope

    @BeforeTest
    fun setup() {
        coroutineContextProvider = fakeCoroutineContextProvider
        coroutineScope = fakeCoroutineScope
        classUnderTest = GetMostWantedListUseCaseImpl(mostWantedRepository, coroutineContextProvider)
    }

    @Test
    fun `When executeInBackground Then verify most wanted list was requested and returned`() = runBlocking {
        // Given
        given(mostWantedRepository).coroutine { getMostWantedList() }.thenReturn(givenMostWantedList)

        // When
        val actualResult = classUnderTest.executeInBackground(Unit, coroutineScope)

        // Then
        verify(mostWantedRepository).coroutine { getMostWantedList() }.wasInvoked(Times(1))
        assertEquals(givenMostWantedList, actualResult)
    }
}
