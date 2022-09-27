package com.psycodeinteractive.fbimostwanted.di

import com.psycodeinteractive.fbimostwanted.domain.execution.UseCaseExecutor
import com.psycodeinteractive.fbimostwanted.domain.logger.Logger
import com.psycodeinteractive.fbimostwanted.presentation.execution.UseCaseExecutorProvider
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper.FileDomainToPresentationMapper
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper.ImageDomainToPresentationMapper
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper.MostWantedPersonDomainToPresentationMapper
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper.SexDomainToPresentationMapper
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper.StatusDomainToPresentationMapper
import com.psycodeinteractive.fbimostwanted.presentation.mapper.DefaultDomainToPresentationExceptionMapper
import kotlinx.coroutines.CoroutineScope
import me.tatarka.inject.annotations.Provides

interface PresentationComponent {

    @Singleton
    @Provides
    fun providesUseCaseExecutorProvider(logger: Logger): UseCaseExecutorProvider = object : UseCaseExecutorProvider {
        override fun invoke(coroutineScope: CoroutineScope) = UseCaseExecutor(coroutineScope, logger)
    }
//        { coroutineScope -> UseCaseExecutor(coroutineScope, logger) }

    @Singleton
    @Provides
    fun providesSexDomainToPresentationMapper() = SexDomainToPresentationMapper()

    @Singleton
    @Provides
    fun providesFileDomainToPresentationMapper() = FileDomainToPresentationMapper()

    @Singleton
    @Provides
    fun providesImageDomainToPresentationMapper() = ImageDomainToPresentationMapper()

    @Singleton
    @Provides
    fun providesStatusDomainToPresentationMapper() = StatusDomainToPresentationMapper()

    @Singleton
    @Provides
    fun providesDefaultDomainToPresentationExceptionMapper() = DefaultDomainToPresentationExceptionMapper()

    @Singleton
    @Provides
    fun providesMostWantedPersonDomainToPresentationMapper(
        sexDomainToPresentationMapper: SexDomainToPresentationMapper,
        fileDomainToPresentationMapper: FileDomainToPresentationMapper,
        imageDomainToPresentationMapper: ImageDomainToPresentationMapper,
        statusDomainToPresentationMapper: StatusDomainToPresentationMapper
    ) = MostWantedPersonDomainToPresentationMapper(
        sexDomainToPresentationMapper,
        fileDomainToPresentationMapper,
        imageDomainToPresentationMapper,
        statusDomainToPresentationMapper
    )
}
