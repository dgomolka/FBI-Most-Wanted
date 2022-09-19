package com.psycodeinteractive.fbimostwanted.di

import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.mapper.FilePresentationToUiMapper
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.mapper.ImagePresentationToUiMapper
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.mapper.MostWantedPersonPresentationToUiMapper
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.mapper.SexPresentationToUiMapper
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.mapper.StatusPresentationToUiMapper
import me.tatarka.inject.annotations.Provides

interface UiComponent {
    @Provides
    fun providesSexPresentationToUiMapper() = SexPresentationToUiMapper()

    @Provides
    fun providesFilePresentationToUiMapper() = FilePresentationToUiMapper()

    @Provides
    fun providesImagePresentationToUiMapper() = ImagePresentationToUiMapper()

    @Provides
    fun providesStatusPresentationToUiMapper() = StatusPresentationToUiMapper()

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
