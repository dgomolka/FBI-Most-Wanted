package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class StatusApiModel {
    @SerialName("captured")
    Captured,

    @SerialName("na")
    NotAvailable,

    @SerialName("recovered")
    Recovered
}
