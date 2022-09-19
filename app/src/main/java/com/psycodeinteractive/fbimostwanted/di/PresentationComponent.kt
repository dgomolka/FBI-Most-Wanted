package com.psycodeinteractive.fbimostwanted.di

import com.psycodeinteractive.fbimostwanted.domain.execution.UseCaseExecutor
import com.psycodeinteractive.fbimostwanted.domain.logger.Logger
import com.psycodeinteractive.fbimostwanted.presentation.execution.UseCaseExecutorProvider
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper.FileDomainToPresentationMapper
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper.ImageDomainToPresentationMapper
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper.MostWantedPersonDomainToPresentationMapper
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper.SexDomainToPresentationMapper
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper.StatusDomainToPresentationMapper
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@Component
abstract class PresentationComponent(
    @Component val domainComponent: DomainComponent,
    @Component val loggerComponent: LoggerComponent
) {
    @Provides
    fun providesUseCaseExecutorProvider(logger: Logger): UseCaseExecutorProvider =
        { coroutineScope -> UseCaseExecutor(coroutineScope, logger) }

    @Provides
    fun providesSexDomainToPresentationMapper() = SexDomainToPresentationMapper()

    @Provides
    fun providesFileDomainToPresentationMapper() = FileDomainToPresentationMapper()

    @Provides
    fun providesImageDomainToPresentationMapper() = ImageDomainToPresentationMapper()

    @Provides
    fun providesStatusDomainToPresentationMapper() = StatusDomainToPresentationMapper()

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
