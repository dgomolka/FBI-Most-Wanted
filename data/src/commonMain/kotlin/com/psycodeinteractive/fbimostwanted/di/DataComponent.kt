package com.psycodeinteractive.fbimostwanted.di

import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper.FileApiToDataMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper.FileDataToDatabaseMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper.FileDataToDomainMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper.FileDatabaseToDataMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper.ImageApiToDataMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper.ImageDataToDatabaseMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper.ImageDataToDomainMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper.ImageDatabaseToDataMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper.MostWantedPersonApiToDataMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper.MostWantedPersonDataToDatabaseMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper.MostWantedPersonDataToDomainMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper.MostWantedPersonDatabaseToDataMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper.SexApiToDataMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper.SexDataToDatabaseMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper.SexDataToDomainMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper.SexDatabaseToDataMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper.StatusApiToDataMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper.StatusDataToDatabaseMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper.StatusDataToDomainMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper.StatusDatabaseToDataMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.local.FileDatabaseModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.local.ImageDatabaseModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.repository.MostWantedDataRepository
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.MostWantedDataSource
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.MostWantedPersonCache
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.local.DatabaseDriverFactory
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.local.MostWantedPersonDatabaseModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.local.MostWantedPersonQueries
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.local.adapter.SerializableListColumnAdapter
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.local.adapter.StringListColumnAdapter
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.remote.MostWantedApiService
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.remote.MostWantedService
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.remote.config.MostWantedApiConfig
import com.psycodeinteractive.fbimostwanted.data.network.ApiConfig
import com.psycodeinteractive.fbimostwanted.data.network.NetworkClient
import com.psycodeinteractive.fbimostwanted.data.source.local.MostWantedAppDatabase
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.repository.MostWantedRepository
import com.squareup.sqldelight.EnumColumnAdapter
import me.tatarka.inject.annotations.Provides

interface DataComponent {
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
    fun providesMostWantedPersonCache() = MostWantedPersonCache()

    @Provides
    fun providesMostWantedPersonQueries(
        mostWantedAppDatabase: MostWantedAppDatabase
    ) = mostWantedAppDatabase.mostWantedPersonQueries

    @Provides
    fun providesApiConfig(): ApiConfig = MostWantedApiConfig

    @Provides
    fun providesNetworkClient(
        apiConfig: ApiConfig
    ) = NetworkClient(apiConfig)

    @Provides
    fun providesMostWantedService(
        networkClient: NetworkClient
    ): MostWantedService = MostWantedApiService(networkClient)

    @Provides
    fun providesMostWantedRepository(
        mostWantedDataSource: MostWantedDataSource,
        mostWantedPersonDataToDomainMapper: MostWantedPersonDataToDomainMapper
    ): MostWantedRepository = MostWantedDataRepository(mostWantedDataSource, mostWantedPersonDataToDomainMapper)

    @Provides
    fun providesMostWantedSource(
        mostWantedService: MostWantedService,
        mostWantedPersonQueries: MostWantedPersonQueries,
        mostWantedPersonApiToDataMapper: MostWantedPersonApiToDataMapper,
        mostWantedPersonDatabaseToDataMapper: MostWantedPersonDatabaseToDataMapper,
        mostWantedPersonDataToDatabaseMapper: MostWantedPersonDataToDatabaseMapper,
        mostWantedPersonCache: MostWantedPersonCache
    ) = MostWantedDataSource(
        mostWantedService,
        mostWantedPersonQueries,
        mostWantedPersonApiToDataMapper,
        mostWantedPersonDatabaseToDataMapper,
        mostWantedPersonDataToDatabaseMapper,
        mostWantedPersonCache
    )

    @Provides
    fun providesMostWantedPersonDataToDomainMapper(
        sexDataToDomainMapper: SexDataToDomainMapper,
        fileDataToDomainMapper: FileDataToDomainMapper,
        imageDataToDomainMapper: ImageDataToDomainMapper,
        statusDataToDomainMapper: StatusDataToDomainMapper
    ) = MostWantedPersonDataToDomainMapper(
        sexDataToDomainMapper,
        fileDataToDomainMapper,
        imageDataToDomainMapper,
        statusDataToDomainMapper
    )

    @Provides
    fun providesSexDataToDomainMapper() = SexDataToDomainMapper()

    @Provides
    fun providesImageDataToDomainMapper() = ImageDataToDomainMapper()

    @Provides
    fun providesFileDataToDomainMapper() = FileDataToDomainMapper()

    @Provides
    fun providesStatusDataToDomainMapper() = StatusDataToDomainMapper()

    @Provides
    fun providesMostWantedPersonApiToDataMapper(
        sexApiToDataMapper: SexApiToDataMapper,
        fileApiToDataMapper: FileApiToDataMapper,
        imageApiToDataMapper: ImageApiToDataMapper,
        statusApiToDataMapper: StatusApiToDataMapper
    ) = MostWantedPersonApiToDataMapper(
        sexApiToDataMapper,
        fileApiToDataMapper,
        imageApiToDataMapper,
        statusApiToDataMapper
    )

    @Provides
    fun providesSexApiToDataMapper() = SexApiToDataMapper()

    @Provides
    fun providesImageApiToDataMapper() = ImageApiToDataMapper()

    @Provides
    fun providesFileApiToDataMapper() = FileApiToDataMapper()

    @Provides
    fun providesStatusApiToDataMapper() = StatusApiToDataMapper()

    @Provides
    fun providesMostWantedPersonDatabaseToDataMapper(
        sexDatabaseToDataMapper: SexDatabaseToDataMapper,
        fileDatabaseToDataMapper: FileDatabaseToDataMapper,
        imageDatabaseToDataMapper: ImageDatabaseToDataMapper,
        statusDatabaseToDataMapper: StatusDatabaseToDataMapper
    ) = MostWantedPersonDatabaseToDataMapper(
        sexDatabaseToDataMapper,
        fileDatabaseToDataMapper,
        imageDatabaseToDataMapper,
        statusDatabaseToDataMapper
    )

    @Provides
    fun providesSexDatabaseToDataMapper() = SexDatabaseToDataMapper()

    @Provides
    fun providesImageDatabaseToDataMapper() = ImageDatabaseToDataMapper()

    @Provides
    fun providesFileDatabaseToDataMapper() = FileDatabaseToDataMapper()

    @Provides
    fun providesStatusDatabaseToDataMapper() = StatusDatabaseToDataMapper()

    @Provides
    fun providesMostWantedPersonDataToDatabaseMapper(
        sexDataToDatabaseMapper: SexDataToDatabaseMapper,
        fileDataToDatabaseMapper: FileDataToDatabaseMapper,
        imageDataToDatabaseMapper: ImageDataToDatabaseMapper,
        statusDataToDatabaseMapper: StatusDataToDatabaseMapper
    ) = MostWantedPersonDataToDatabaseMapper(
        sexDataToDatabaseMapper,
        fileDataToDatabaseMapper,
        imageDataToDatabaseMapper,
        statusDataToDatabaseMapper
    )

    @Provides
    fun providesSexDataToDatabaseMapper() = SexDataToDatabaseMapper()

    @Provides
    fun providesFileDataToDatabaseMapper() = FileDataToDatabaseMapper()

    @Provides
    fun providesImageDataToDatabaseMapper() = ImageDataToDatabaseMapper()

    @Provides
    fun providesStatusDataToDatabaseMapper() = StatusDataToDatabaseMapper()
}
