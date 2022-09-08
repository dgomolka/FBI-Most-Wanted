package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model

data class MostWantedPersonDataModel(
    val uid: String,
    val id: String,

    val rewardText: String,
    val aliases: List<String>,
    val publication: String,
    val url: String,
    val warningMessage: String,

    val details: String,

    val occupations: List<String>,

    val nationality: String,

    val placeOfBirth: String,
    val datesOfBirthUsed: List<String>,

    val languages: List<String>,

    val sex: SexDataModel,

    val scarsAndMarks: String,
    val complexion: String,
    val race: String,
    val raceRaw: String,
    val build: String,
    val hair: String,
    val hairRaw: String,
    val eyes: String,
    val eyesRaw: String,

    val ageMin: Long,
    val ageMax: Long,
    val ageRange: String,

    val weight: String,
    val weightMin: Long,
    val weightMax: Long,

    val heightMin: Long,
    val heightMax: Long,

    val rewardMin: Long,
    val rewardMax: Long,

    val files: List<FileDataModel>,
    val images: List<ImageDataModel>,

    val title: String,
    val description: String,
    val status: StatusDataModel,
    val remarks: String,
    val path: String,

    val possibleStates: List<String>,
    val possibleCountries: List<String>,

    val caution: String,
    val modified: String,

    val subjects: List<String>,

    val ncic: String,

    val fieldOffices: List<String>
)
