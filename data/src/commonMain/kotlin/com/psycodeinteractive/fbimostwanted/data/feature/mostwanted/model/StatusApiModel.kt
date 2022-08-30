package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model

import kotlinx.serialization.Serializable

@Serializable
enum class StatusApiModel(val value: String) {
    Captured("captured"),
    NotAvailable("na"),
    Recovered("recovered")
}
