package com.psycodeinteractive.fbimostwanted.data.mostwanted.model

import kotlinx.serialization.Serializable

@Serializable
enum class SexApiModel(val value: String) {
    Female("Female"),
    Male("Male")
}
