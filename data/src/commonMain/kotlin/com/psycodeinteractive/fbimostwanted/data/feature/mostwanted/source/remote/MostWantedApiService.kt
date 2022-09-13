package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.remote

import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.remote.MostWantedPersonApiModel

class MostWantedApiService(
//    private val networkClient: NetworkClient
) : MostWantedService {
    override suspend fun mostWantedList(): List<MostWantedPersonApiModel> {
        TODO("Not yet implemented")
    }

}
