package com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedlist

import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.usecase.GetMostWantedListUseCase
import com.psycodeinteractive.fbimostwanted.domain.logger.Logger
import com.psycodeinteractive.fbimostwanted.presentation.execution.UseCaseExecutorProvider
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper.MostWantedPersonDomainToPresentationMapper
import com.psycodeinteractive.fbimostwanted.presentation.mapper.DefaultDomainToPresentationExceptionMapper
import io.mockative.Mock
import io.mockative.mock
import kotlin.test.BeforeTest

class MostWantedListViewModelTest {

    @Mock
    val mostWantedPersonDomainToPresentationMapper = mock(MostWantedPersonDomainToPresentationMapper::class)

    @Mock
    val getMostWantedListUseCase = mock(GetMostWantedListUseCase::class)

    @Mock
    val useCaseExecutorProvider = mock(UseCaseExecutorProvider::class)

    @Mock
    val defaultDomainToPresentationExceptionMapper = mock(DefaultDomainToPresentationExceptionMapper::class)

    @Mock
    val logger = mock(Logger::class)

    private lateinit var classUnderTest: MostWantedListViewModel

    @BeforeTest
    fun setup() {
        classUnderTest = MostWantedListViewModel(
            mostWantedPersonDomainToPresentationMapper = mostWantedPersonDomainToPresentationMapper,
            getMostWantedListUseCase = getMostWantedListUseCase,
            useCaseExecutorProvider = useCaseExecutorProvider,
            defaultDomainToPresentationExceptionMapper = defaultDomainToPresentationExceptionMapper,
            logger = logger
        )
    }
}
