package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class SexApiModel {
    @SerialName("Female")
    Female,
    @SerialName("Male")
    Male
}
