package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.remote

import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.remote.MostWantedPersonApiModel

interface MostWantedService {
    suspend fun mostWantedList(): List<MostWantedPersonApiModel>
}
