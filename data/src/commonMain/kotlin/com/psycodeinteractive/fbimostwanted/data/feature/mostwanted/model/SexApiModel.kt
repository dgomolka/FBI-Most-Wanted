package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model

import kotlinx.serialization.Serializable

@Serializable
enum class SexApiModel(val value: String) {
    Female("Female"),
    Male("Male")
}
