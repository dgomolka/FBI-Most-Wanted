package com.psycodeinteractive.fbimostwanted.data.feature.session

import com.psycodeinteractive.fbimostwanted.data.source.DataSource
import com.psycodeinteractive.fbimostwanted.domain.feature.session.repository.AppSessionRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

class AppSessionDataRepository(
    private val dataSources: List<DataSource<*>>
) : AppSessionRepository {

    override suspend fun startSession() {
        initializeDataSources()
    }

    override suspend fun stopSession() {
    }

    override suspend fun clearSession() {
    }

    private suspend fun initializeDataSources() {
        coroutineScope {
            dataSources.map {
                async {
                    it.initialize()
                }
            }.awaitAll()
        }
    }
}
