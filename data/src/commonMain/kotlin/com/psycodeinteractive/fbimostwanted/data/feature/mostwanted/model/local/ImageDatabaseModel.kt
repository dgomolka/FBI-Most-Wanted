package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.local

@kotlinx.serialization.Serializable
data class ImageDatabaseModel(
    val original: String,
    val thumb: String,
    val large: String,
    val caption: String
)
