package com.psycodeinteractive.fbimostwanted.di

import com.psycodeinteractive.fbimostwanted.domain.coroutine.CoroutineContextProvider
import com.psycodeinteractive.fbimostwanted.domain.coroutine.PlatformCoroutineContextProvider
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.repository.MostWantedRepository
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.usecase.GetMostWantedListUseCase
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.usecase.GetMostWantedListUseCaseImpl
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.usecase.GetMostWantedPersonUseCase
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.usecase.GetMostWantedPersonUseCaseImpl
import com.psycodeinteractive.fbimostwanted.domain.feature.session.repository.AppSessionRepository
import com.psycodeinteractive.fbimostwanted.domain.feature.session.usecase.StartSessionUseCase
import com.psycodeinteractive.fbimostwanted.domain.feature.session.usecase.StartSessionUseCaseImpl
import com.psycodeinteractive.fbimostwanted.domain.feature.session.usecase.StopSessionUseCase
import com.psycodeinteractive.fbimostwanted.domain.feature.session.usecase.StopSessionUseCaseImpl
import me.tatarka.inject.annotations.Provides

interface DomainComponent {

    @Singleton
    @Provides
    fun provideCoroutineContextProvider(): CoroutineContextProvider =
        PlatformCoroutineContextProvider

    @Singleton
    @Provides
    fun providesGetMostWantedListUseCase(
        mostWantedRepository: MostWantedRepository,
        coroutineContextProvider: CoroutineContextProvider
    ): GetMostWantedListUseCase = GetMostWantedListUseCaseImpl(mostWantedRepository, coroutineContextProvider)

    @Singleton
    @Provides
    fun providesGetMostWantedPersonUseCase(
        mostWantedRepository: MostWantedRepository,
        coroutineContextProvider: CoroutineContextProvider
    ): GetMostWantedPersonUseCase = GetMostWantedPersonUseCaseImpl(mostWantedRepository, coroutineContextProvider)

    @Singleton
    @Provides
    fun providesStartSessionUseCase(
        appSessionRepository: AppSessionRepository,
        coroutineContextProvider: CoroutineContextProvider
    ): StartSessionUseCase = StartSessionUseCaseImpl(appSessionRepository, coroutineContextProvider)

    @Singleton
    @Provides
    fun providesStopSessionUseCase(
        appSessionRepository: AppSessionRepository,
        coroutineContextProvider: CoroutineContextProvider
    ): StopSessionUseCase = StopSessionUseCaseImpl(appSessionRepository, coroutineContextProvider)
}
