package com.psycodeinteractive.fbimostwanted.di

import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.MostWantedPersonDataModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.repository.MostWantedDataRepository
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.MostWantedDataSource
import com.psycodeinteractive.fbimostwanted.data.source.DataSource
import com.psycodeinteractive.fbimostwanted.data.source.local.MostWantedAppDatabase
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.repository.MostWantedRepository
import me.tatarka.inject.annotations.Provides

class DataComponent {

    @Provides
    fun providesMostWantedApplicationDatabase() = MostWantedAppDatabase(
        driver = ,
        ada
    )

    @Provides
    fun providesMostWantedPersonQueries(
        mostWantedAppDatabase: MostWantedAppDatabase
    ) = mostWantedAppDatabase.mostWantedPersonQueries

    @Provides
    fun providesMostWantedRepository(
        mostWantedDataSource: MostWantedDataSource
    ): MostWantedRepository = MostWantedDataRepository(mostWantedDataSource)

    @Provides
    fun providesMostWantedSource() = MostWantedDataSource()
}
