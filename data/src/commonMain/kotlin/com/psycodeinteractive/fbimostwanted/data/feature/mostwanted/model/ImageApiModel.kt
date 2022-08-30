package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model

import kotlinx.serialization.Serializable

@Serializable
data class ImageApiModel(
    val original: String,
    val thumb: String,
    val large: String,
    val caption: String? = null
)
