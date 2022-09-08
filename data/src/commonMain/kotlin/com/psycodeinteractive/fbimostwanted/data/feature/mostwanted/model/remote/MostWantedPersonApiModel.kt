package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MostWantedPersonApiModel(
    @SerialName("reward_text")
    val rewardText: String? = null,

    val aliases: List<String>? = null,
    val publication: String,
    val url: String,

    @SerialName("warning_message")
    val warningMessage: String? = null,

    @SerialName("age_max")
    val ageMax: Long? = null,

    @SerialName("weight_min")
    val weightMin: Long? = null,

    @SerialName("height_min")
    val heightMin: Long? = null,

    @SerialName("field_offices")
    val fieldOffices: List<String>? = null,

    @SerialName("age_min")
    val ageMin: Long? = null,

    val occupations: List<String>? = null,

    @SerialName("height_max")
    val heightMax: Long? = null,

    val details: String? = null,

    @SerialName("weight_max")
    val weightMax: Long? = null,

    val sex: SexApiModel? = null,

    @SerialName("scars_and_marks")
    val scarsAndMarks: String? = null,

    val build: String? = null,

    @SerialName("reward_max")
    val rewardMax: Long,

    val nationality: String? = null,

    @SerialName("reward_min")
    val rewardMin: Long,

    val caution: String? = null,
    val race: String? = null,
    val hair: String? = null,
    val modified: String,
    val weight: String? = null,

    @SerialName("place_of_birth")
    val placeOfBirth: String? = null,

    val description: String,

    @SerialName("age_range")
    val ageRange: String? = null,

    val title: String,

    @SerialName("eyes_raw")
    val eyesRaw: String? = null,

    val files: List<FileApiModel>,
    val images: List<ImageApiModel>,
    val uid: String,

    @SerialName("hair_raw")
    val hairRaw: String? = null,

    val status: StatusApiModel,
    val remarks: String? = null,
    val path: String,
    val complexion: String? = null,

    @SerialName("possible_states")
    val possibleStates: List<String>? = null,

    val eyes: String? = null,
    val subjects: List<String>,
    val languages: List<String>? = null,
    val ncic: String? = null,

    @SerialName("possible_countries")
    val possibleCountries: List<String>? = null,

    @SerialName("dates_of_birth_used")
    val datesOfBirthUsed: List<String>? = null,

    @SerialName("race_raw")
    val raceRaw: String? = null,

    @SerialName("@id")
    val id: String
)
