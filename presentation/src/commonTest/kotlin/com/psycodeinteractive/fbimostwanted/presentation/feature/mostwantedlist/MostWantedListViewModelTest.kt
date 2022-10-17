package com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedlist

import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.usecase.GetMostWantedListUseCase
import com.psycodeinteractive.fbimostwanted.presentation.execution.UseCaseExecutorProvider
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper.MostWantedPersonDomainToPresentationMapper
import com.psycodeinteractive.fbimostwanted.presentation.mapper.DefaultDomainToPresentationExceptionMapper
import io.mockative.Mock
import io.mockative.mock
import kotlin.test.BeforeTest
import kotlin.test.Test

class MostWantedListViewModelTest {

    @Mock
    val mostWantedPersonDomainToPresentationMapper = mock(MostWantedPersonDomainToPresentationMapper::class)

    @Mock
    val getMostWantedListUseCase = mock(GetMostWantedListUseCase::class)

    @Mock
    val useCaseExecutorProvider = mock(UseCaseExecutorProvider::class)

    @Mock
    val defaultDomainToPresentationExceptionMapper = mock(DefaultDomainToPresentationExceptionMapper::class)

    private lateinit var classUnderTest: MostWantedListViewModel

    @BeforeTest
    fun setup() {
        classUnderTest = MostWantedListViewModel(
            mostWantedPersonDomainToPresentationMapper = mostWantedPersonDomainToPresentationMapper,
            getMostWantedListUseCase = getMostWantedListUseCase,
            useCaseExecutorProvider = useCaseExecutorProvider,
            defaultDomainToPresentationExceptionMapper = defaultDomainToPresentationExceptionMapper
        )
    }

    @Test
    fun `test`() {
        // Given

        // When

        // Then
    }
}
