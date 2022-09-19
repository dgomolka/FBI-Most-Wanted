package com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.model

data class MostWantedPersonPresentationModel(
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

    val sex: SexPresentationModel,

    val scarsAndMarks: String,
    val complexion: String,
    val race: String,
    val raceRaw: String,
    val build: String,
    val hair: String,
    val hairRaw: String,
    val eyes: String,
    val eyesRaw: String,

    val ageMin: Int,
    val ageMax: Int,
    val ageRange: String,

    val weight: String,
    val weightMin: Int,
    val weightMax: Int,

    val heightMin: Int,
    val heightMax: Int,

    val rewardMin: Int,
    val rewardMax: Int,

    val files: List<FilePresentationModel>,
    val images: List<ImagePresentationModel>,

    val title: String,
    val description: String,
    val status: StatusPresentationModel,
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
