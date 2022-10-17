package com.psycodeinteractive.fbimostwanted.di

import com.psycodeinteractive.fbimostwanted.domain.execution.UseCaseExecutorImpl
import com.psycodeinteractive.fbimostwanted.domain.logger.Logger
import com.psycodeinteractive.fbimostwanted.presentation.execution.UseCaseExecutorProvider
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper.FileDomainToPresentationMapper
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper.FileDomainToPresentationMapperImpl
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper.ImageDomainToPresentationMapper
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper.ImageDomainToPresentationMapperImpl
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper.MostWantedPersonDomainToPresentationMapper
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper.MostWantedPersonDomainToPresentationMapperImpl
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper.SexDomainToPresentationMapper
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper.SexDomainToPresentationMapperImpl
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper.StatusDomainToPresentationMapper
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper.StatusDomainToPresentationMapperImpl
import com.psycodeinteractive.fbimostwanted.presentation.mapper.DefaultDomainToPresentationExceptionMapper
import com.psycodeinteractive.fbimostwanted.presentation.mapper.DefaultDomainToPresentationExceptionMapperImpl
import kotlinx.coroutines.CoroutineScope
import me.tatarka.inject.annotations.Provides

interface PresentationComponent {

    @Singleton
    @Provides
    fun providesUseCaseExecutorProvider(logger: Logger): UseCaseExecutorProvider = object : UseCaseExecutorProvider {
        override fun invoke(coroutineScope: CoroutineScope) = UseCaseExecutorImpl(coroutineScope, logger)
    }
//        { coroutineScope -> UseCaseExecutor(coroutineScope, logger) }

    @Singleton
    @Provides
    fun providesSexDomainToPresentationMapper(): SexDomainToPresentationMapper = SexDomainToPresentationMapperImpl()

    @Singleton
    @Provides
    fun providesFileDomainToPresentationMapper(): FileDomainToPresentationMapper = FileDomainToPresentationMapperImpl()

    @Singleton
    @Provides
    fun providesImageDomainToPresentationMapper(): ImageDomainToPresentationMapper = ImageDomainToPresentationMapperImpl()

    @Singleton
    @Provides
    fun providesStatusDomainToPresentationMapper(): StatusDomainToPresentationMapper = StatusDomainToPresentationMapperImpl()

    @Singleton
    @Provides
    fun providesDefaultDomainToPresentationExceptionMapper(): DefaultDomainToPresentationExceptionMapper =
        DefaultDomainToPresentationExceptionMapperImpl()

    @Singleton
    @Provides
    fun providesMostWantedPersonDomainToPresentationMapper(
        sexDomainToPresentationMapper: SexDomainToPresentationMapper,
        fileDomainToPresentationMapper: FileDomainToPresentationMapper,
        imageDomainToPresentationMapper: ImageDomainToPresentationMapper,
        statusDomainToPresentationMapper: StatusDomainToPresentationMapper
    ): MostWantedPersonDomainToPresentationMapper = MostWantedPersonDomainToPresentationMapperImpl(
        sexDomainToPresentationMapper,
        fileDomainToPresentationMapper,
        imageDomainToPresentationMapper,
        statusDomainToPresentationMapper
    )
}
