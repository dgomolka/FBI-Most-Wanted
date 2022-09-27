package com.psycodeinteractive.fbimostwanted.di

import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.mapper.FilePresentationToUiMapper
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.mapper.ImagePresentationToUiMapper
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.mapper.MostWantedPersonPresentationToUiMapper
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.mapper.SexPresentationToUiMapper
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.mapper.StatusPresentationToUiMapper
import me.tatarka.inject.annotations.Provides

interface UiComponent {

    @Singleton
    @Provides
    fun providesSexPresentationToUiMapper() = SexPresentationToUiMapper()

    @Singleton
    @Provides
    fun providesFilePresentationToUiMapper() = FilePresentationToUiMapper()

    @Singleton
    @Provides
    fun providesImagePresentationToUiMapper() = ImagePresentationToUiMapper()

    @Singleton
    @Provides
    fun providesStatusPresentationToUiMapper() = StatusPresentationToUiMapper()

    @Singleton
    @Provides
    fun providesMostWantedPersonPresentationToUiMapper(
        sexPresentationToUiMapper: SexPresentationToUiMapper,
        filePresentationToUiMapper: FilePresentationToUiMapper,
        imagePresentationToUiMapper: ImagePresentationToUiMapper,
        statusPresentationToUiMapper: StatusPresentationToUiMapper
    ) = MostWantedPersonPresentationToUiMapper(
        sexPresentationToUiMapper,
        filePresentationToUiMapper,
        imagePresentationToUiMapper,
        statusPresentationToUiMapper
    )
}
