package com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.usecase

import com.psycodeinteractive.fbimostwanted.domain.coroutine.fakeCoroutineContextProvider
import com.psycodeinteractive.fbimostwanted.domain.coroutine.fakeCoroutineScope
import com.psycodeinteractive.fbimostwanted.domain.execution.usecase.CoroutineContextProvider
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.repository.MostWantedRepository
import io.mockative.Mock
import io.mockative.Times
import io.mockative.classOf
import io.mockative.configure
import io.mockative.given
import io.mockative.mock
import io.mockative.verify
import kotlinx.coroutines.runBlocking
import kotlin.test.BeforeTest
import kotlin.test.Test

class GetMostWantedListUseCaseImplTest {

    @Mock
    val mostWantedRepository = mock(classOf<MostWantedRepository>())

    private lateinit var classUnderTest: GetMostWantedListUseCaseImpl

    private lateinit var coroutineContextProvider: CoroutineContextProvider

    @BeforeTest
    fun setup() {
        coroutineContextProvider = fakeCoroutineContextProvider
        classUnderTest = GetMostWantedListUseCaseImpl(mostWantedRepository, coroutineContextProvider)
        configure(mostWantedRepository) { stubsUnitByDefault = true }

    }

    @Test
    fun `When executeInBackground Then verify list was requested`() = runBlocking {
        val coroutineScope = fakeCoroutineScope

        classUnderTest.executeInBackground(Unit, coroutineScope)

        given(mostWantedRepository).coroutine { getMostWantedList() }.then { emptyList() }

        verify(mostWantedRepository).coroutine { getMostWantedList() }.wasInvoked(Times(1))
    }
}
