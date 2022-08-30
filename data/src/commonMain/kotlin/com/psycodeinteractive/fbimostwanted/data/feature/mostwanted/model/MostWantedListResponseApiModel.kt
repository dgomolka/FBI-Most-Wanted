package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model

import kotlinx.serialization.Serializable

@Serializable
data class MostWantedListResponseApiModel(
    val total: Long,
    val items: List<MostWantedPersonApiModel>,
    val page: Long
)
