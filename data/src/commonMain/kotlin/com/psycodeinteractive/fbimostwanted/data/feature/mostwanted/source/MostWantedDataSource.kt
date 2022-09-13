package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source

import com.psycodeinteractive.fbimostwanted.data.cache.Cache
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper.MostWantedPersonApiToDataMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper.MostWantedPersonDataToDatabaseMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper.MostWantedPersonDatabaseToDataMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.MostWantedPersonDataModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.local.MostWantedPersonQueries
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.remote.MostWantedService
import com.psycodeinteractive.fbimostwanted.data.source.DataSource

class MostWantedDataSource(
    private val mostWantedService: MostWantedService,
    private val mostWantedPersonQueries: MostWantedPersonQueries,
    private val mostWantedPersonApiToDataMapper: MostWantedPersonApiToDataMapper,
    private val mostWantedPersonDatabaseToDataMapper: MostWantedPersonDatabaseToDataMapper,
    private val mostWantedPersonDataToDatabaseMapper: MostWantedPersonDataToDatabaseMapper,
    private val cache: Cache<List<MostWantedPersonDataModel>>
) : DataSource<List<MostWantedPersonDataModel>> {
    override suspend fun initialize() {
        cache.emit { fetchLocal() }
    }

    override suspend fun refresh() {
        cache.emit { fetchRemote() }
    }

    override suspend fun get() = cache.emitOnEmpty {
        fetchRemote()
    }.flow

    private suspend fun fetchRemote() = mostWantedService.mostWantedList()
        .map(mostWantedPersonApiToDataMapper::toData)
        .apply(::saveLocal)

    private fun fetchLocal() = mostWantedPersonQueries.selectAllMostWanted()
        .executeAsList()
        .map(mostWantedPersonDatabaseToDataMapper::toData)

    private fun saveLocal(mostWantedList: List<MostWantedPersonDataModel>) {
        mostWantedList.forEach { mostWantedPerson ->
            mostWantedPersonQueries.insertMostWantedPerson(
                mostWantedPersonDataToDatabaseMapper.toDatabase(mostWantedPerson)
            )
        }
    }
}
