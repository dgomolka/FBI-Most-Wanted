package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source

import com.psycodeinteractive.fbimostwanted.data.cache.Cache
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.MostWantedPersonDataModel
import com.psycodeinteractive.fbimostwanted.data.source.DataSource
import kotlinx.coroutines.flow.Flow

class MostWantedDataSource(
    private val mostWantedService: MostWantedService,
    private val mostWantedDatabase: MostWantedDatabase,
    private val mostWantedCache: Cache<List<MostWantedPersonDataModel>>
): DataSource<List<MostWantedPersonDataModel>> {
    override fun refresh() {

    }

    override suspend fun get(): Flow<List<MostWantedPersonDataModel>> {

    }
}
