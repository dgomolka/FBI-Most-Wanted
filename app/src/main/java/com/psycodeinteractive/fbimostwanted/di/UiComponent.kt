package com.psycodeinteractive.fbimostwanted.di

import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.mapper.FilePresentationToUiMapper
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.mapper.ImagePresentationToUiMapper
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.mapper.MostWantedPersonPresentationToUiMapper
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.mapper.SexPresentationToUiMapper
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.mapper.StatusPresentationToUiMapper
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@Component
abstract class UiComponent {
    @Provides
    public fun providesSexPresentationToUiMapper() = SexPresentationToUiMapper()

    @Provides
    public fun providesFilePresentationToUiMapper() = FilePresentationToUiMapper()

    @Provides
    public fun providesImagePresentationToUiMapper() = ImagePresentationToUiMapper()

    @Provides
    public fun providesStatusPresentationToUiMapper() = StatusPresentationToUiMapper()

    @Provides
    public fun providesMostWantedPersonPresentationToUiMapper(
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
