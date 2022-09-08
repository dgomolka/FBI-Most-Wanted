package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper

import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.MostWantedPersonDataModel
import com.psycodeinteractive.fbimostwanted.domain.contract.mapper.DataToDomainMapper
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.MostWantedPersonDomainModel

class MostWantedPersonDataToDomainMapper(
    private val sexDataToDomainMapper: SexDataToDomainMapper,
    private val fileDataToDomainMapper: FileDataToDomainMapper,
    private val imageDataToDomainMapper: ImageDataToDomainMapper,
    private val statusDataToDomainMapper: StatusDataToDomainMapper
) : DataToDomainMapper<MostWantedPersonDataModel, MostWantedPersonDomainModel>() {
    override fun map(input: MostWantedPersonDataModel) = MostWantedPersonDomainModel(
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

        sex = sexDataToDomainMapper.toData(input.sex),

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

        files = input.files.map(fileDataToDomainMapper::toData),
        images = input.images.map(imageDataToDomainMapper::toData),

        title = input.title,
        description = input.description,
        status = statusDataToDomainMapper.toData(input.status),
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
