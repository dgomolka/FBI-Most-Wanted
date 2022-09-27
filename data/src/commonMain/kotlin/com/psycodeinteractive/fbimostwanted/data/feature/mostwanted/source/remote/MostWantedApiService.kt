package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.remote

import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.remote.MostWantedListResponseApiModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.remote.MostWantedPersonApiModel
import com.psycodeinteractive.fbimostwanted.data.network.NetworkClient

class MostWantedApiService(
    private val networkClient: NetworkClient
) : MostWantedService {
    override suspend fun mostWantedList(): List<MostWantedPersonApiModel> =
        networkClient.get<MostWantedListResponseApiModel>(
            path = "/@wanted",
            queryParameters = listOf(
                
            )
        ).items
}
