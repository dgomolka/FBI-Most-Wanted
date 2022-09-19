package com.psycodeinteractive.fbimostwanted.di

import com.psycodeinteractive.fbimostwanted.domain.execution.usecase.CoroutineContextProvider
import com.psycodeinteractive.fbimostwanted.domain.execution.usecase.PlatformCoroutineContextProvider
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.repository.MostWantedRepository
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.usecase.GetMostWantedListUseCase
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.usecase.GetMostWantedListUseCaseImpl
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.usecase.GetMostWantedPersonUseCase
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.usecase.GetMostWantedPersonUseCaseImpl
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@Component
abstract class DomainComponent(
    @Component val dataComponent: DataComponent
) {

    @Provides
    fun provideCoroutineContextProvider(): CoroutineContextProvider =
        PlatformCoroutineContextProvider

    @Provides
    fun providesGetMostWantedListUseCase(
        mostWantedRepository: MostWantedRepository,
        coroutineContextProvider: CoroutineContextProvider
    ): GetMostWantedListUseCase = GetMostWantedListUseCaseImpl(mostWantedRepository, coroutineContextProvider)

    @Provides
    fun providesGetMostWantedPersonUseCase(
        mostWantedRepository: MostWantedRepository,
        coroutineContextProvider: CoroutineContextProvider
    ): GetMostWantedPersonUseCase = GetMostWantedPersonUseCaseImpl(mostWantedRepository, coroutineContextProvider)
}

val domainComponent = DomainComponent::class.create(dataComponent)
