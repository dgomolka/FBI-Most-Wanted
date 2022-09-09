package com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.mapper

import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.model.MostWantedPersonPresentationModel
import com.psycodeinteractive.fbimostwanted.ui.contract.mapper.PresentationToUiMapper
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.model.MostWantedPersonUiModel

class MostWantedPersonPresentationToUiMapper(
    private val sexDomainToPresentationMapper: SexPresentationToUiMapper,
    private val fileDomainToPresentationMapper: FilePresentationToUiMapper,
    private val imageDomainToPresentationMapper: ImagePresentationToUiMapper,
    private val statusDomainToPresentationMapper: StatusPresentationToUiMapper
) : PresentationToUiMapper<MostWantedPersonPresentationModel, MostWantedPersonUiModel>() {
    override fun map(input: MostWantedPersonPresentationModel) = MostWantedPersonUiModel(
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

        sex = sexDomainToPresentationMapper.toUi(input.sex),

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

        files = input.files.map(fileDomainToPresentationMapper::toUi),
        images = input.images.map(imageDomainToPresentationMapper::toUi),

        title = input.title,
        description = input.description,
        status = statusDomainToPresentationMapper.toUi(input.status),
        remarks = input.remarks,
        path = input.path,

        possibleStates = input.possibleStates,
        possibleCountries = input.possibleCountries,

        caution = input.caution,
        modified = input.modified,

        subjects = input.subjects,

        ncic = input.ncic,

        fieldOffices = input.fieldOffices
    )
}
