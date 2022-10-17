package com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.usecase

import com.psycodeinteractive.fbimostwanted.domain.coroutine.testCoroutineContextProvider
import com.psycodeinteractive.fbimostwanted.domain.coroutine.testCoroutineScope
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.givenMostWantedList
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
class GetMostWantedListUseCaseImplTest {

    @Mock
    val mostWantedRepository = mock(classOf<MostWantedRepository>())

    private lateinit var classUnderTest: GetMostWantedListUseCaseImpl

    @BeforeTest
    fun setup() {
        classUnderTest = GetMostWantedListUseCaseImpl(mostWantedRepository, testCoroutineContextProvider)
    }

    @Test
    fun `When executeInBackground Then verify most wanted list was requested and returned`() = testCoroutineScope.runTest {
        // Given
        given(mostWantedRepository).coroutine { getMostWantedList() }.thenReturn(givenMostWantedList)

        // When
        val actualResult = classUnderTest.executeInBackground(Unit, testCoroutineScope)

        // Then
        verify(mostWantedRepository).coroutine { getMostWantedList() }.wasInvoked(once)
        assertEquals(givenMostWantedList, actualResult)
    }
}
