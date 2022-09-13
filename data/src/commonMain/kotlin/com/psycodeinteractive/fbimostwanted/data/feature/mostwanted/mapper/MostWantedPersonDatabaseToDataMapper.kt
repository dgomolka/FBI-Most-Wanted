package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper

import com.psycodeinteractive.fbimostwanted.data.contract.mapper.DatabaseToDataMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.MostWantedPersonDataModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.local.MostWantedPersonDatabaseModel

class MostWantedPersonDatabaseToDataMapper(
    private val sexDatabaseToDataMapper: SexDatabaseToDataMapper,
    private val fileDatabaseToDataMapper: FileDatabaseToDataMapper,
    private val imageDatabaseToDataMapper: ImageDatabaseToDataMapper,
    private val statusDatabaseToDataMapper: StatusDatabaseToDataMapper
) : DatabaseToDataMapper<MostWantedPersonDatabaseModel, MostWantedPersonDataModel>() {
    override fun map(input: MostWantedPersonDatabaseModel) = MostWantedPersonDataModel(
        uid = input.uid,
        id = input.id,
        rewardText = input.rewardText,
        aliases = input.aliases,
        publication = input.publication,
        url = input.url,
        warningMessage = input.warningMessage,
        details = input.details,
        occupations = input.occupations,
        nationality = input.nationality,
        placeOfBirth = input.placeOfBirth,
        datesOfBirthUsed = input.datesOfBirthUsed,
        languages = input.languages,
        sex = sexDatabaseToDataMapper.toData(input.sex),
        scarsAndMarks = input.scarsAndMarks,
        complexion = input.complexion,
        race = input.race,
        raceRaw = input.raceRaw,
        build = input.build,
        hair = input.hair,
        hairRaw = input.hairRaw,
        eyes = input.eyes,
        eyesRaw = input.eyesRaw,
        ageMin = input.ageMin,
        ageMax = input.ageMax,
        ageRange = input.ageRange,
        weight = input.weight,
        weightMin = input.weightMin,
        weightMax = input.weightMax,
        heightMin = input.heightMin,
        heightMax = input.heightMax,
        rewardMin = input.rewardMin,
        rewardMax = input.rewardMax,
        files = input.files.map(fileDatabaseToDataMapper::toData),
        images = input.images.map(imageDatabaseToDataMapper::toData),
        title = input.title,
        description = input.description,
        status = statusDatabaseToDataMapper.toData(input.status),
        remarks = input.remarks,
        path = input.path,
        possibleStates = input.possibleStates,
        possibleCountries = input.possibleCountries,
        caution = input.caution,
        modified = input.modified,
        subjects = input.subjects,
        ncic = input.ncic,
        fieldOffices = input.fieldOffices,
    )
}
