package com.psycodeinteractive.fbimostwanted.di

import android.app.Application
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.local.FileDatabaseModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.local.ImageDatabaseModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.repository.MostWantedDataRepository
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.MostWantedDataSource
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.local.DatabaseDriverFactory
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.local.MostWantedPersonDatabaseModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.local.adapter.SerializableListColumnAdapter
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.local.adapter.StringListColumnAdapter
import com.psycodeinteractive.fbimostwanted.data.source.local.MostWantedAppDatabase
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.repository.MostWantedRepository
import com.squareup.sqldelight.EnumColumnAdapter
import me.tatarka.inject.annotations.Provides

class DataComponent {

    @Provides
    fun providesDatabaseDriverFactory(application: Application) = DatabaseDriverFactory(application)

    @Provides
    fun providesMostWantedApplicationDatabase(
        databaseDriverFactory: DatabaseDriverFactory
    ) = MostWantedAppDatabase(
        driver = databaseDriverFactory.createDriver(),
        MostWantedPersonDatabaseModelAdapter = MostWantedPersonDatabaseModel.Adapter(
            aliasesAdapter = StringListColumnAdapter,
            occupationsAdapter = StringListColumnAdapter,
            datesOfBirthUsedAdapter = StringListColumnAdapter,
            languagesAdapter = StringListColumnAdapter,
            sexAdapter = EnumColumnAdapter(),
            filesAdapter = SerializableListColumnAdapter(FileDatabaseModel.serializer()),
            imagesAdapter = SerializableListColumnAdapter(ImageDatabaseModel.serializer()),
            statusAdapter = EnumColumnAdapter(),
            possibleStatesAdapter = StringListColumnAdapter,
            possibleCountriesAdapter = StringListColumnAdapter,
            subjectsAdapter = StringListColumnAdapter,
            fieldOfficesAdapter = StringListColumnAdapter
        )
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
