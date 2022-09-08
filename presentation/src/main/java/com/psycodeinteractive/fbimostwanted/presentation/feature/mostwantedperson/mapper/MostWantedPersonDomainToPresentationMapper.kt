package com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper

import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.MostWantedPersonDomainModel
import com.psycodeinteractive.fbimostwanted.presentation.contract.mapper.DomainToPresentationMapper
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.model.MostWantedPersonPresentationModel

class MostWantedPersonDomainToPresentationMapper(
    private val sexDomainToPresentationMapper: SexDomainToPresentationMapper,
    private val fileDomainToPresentationMapper: FileDomainToPresentationMapper,
    private val imageDomainToPresentationMapper: ImageDomainToPresentationMapper,
    private val statusDomainToPresentationMapper: StatusDomainToPresentationMapper
) : DomainToPresentationMapper<MostWantedPersonDomainModel, MostWantedPersonPresentationModel>() {
    override fun map(input: MostWantedPersonDomainModel) = MostWantedPersonPresentationModel(
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

        sex = sexDomainToPresentationMapper.toData(input.sex),

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

        files = input.files.map(fileDomainToPresentationMapper::toData),
        images = input.images.map(imageDomainToPresentationMapper::toData),

        title = input.title,
        description = input.description,
        status = statusDomainToPresentationMapper.toData(input.status),
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
