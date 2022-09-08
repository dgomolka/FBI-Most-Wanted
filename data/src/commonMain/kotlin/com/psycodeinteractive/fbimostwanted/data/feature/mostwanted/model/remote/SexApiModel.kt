package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.remote

import kotlinx.serialization.Serializable

@Serializable
enum class SexApiModel(val value: String) {
    Female("Female"),
    Male("Male")
}
