package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper

import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.MostWantedPersonDataModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.SexDataModel.Unspecified
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.remote.MostWantedPersonApiModel
import com.psycodeinteractive.fbimostwanted.domain.contract.mapper.DataToDomainMapper

class MostWantedPersonApiToDataMapper(
    private val sexApiToDataMapper: SexApiToDataMapper,
    private val fileApiToDataMapper: FileApiToDataMapper,
    private val imageApiToDataMapper: ImageApiToDataMapper,
    private val statusApiToDataMapper: StatusApiToDataMapper
) : DataToDomainMapper<MostWantedPersonApiModel, MostWantedPersonDataModel>() {
    override fun map(input: MostWantedPersonApiModel) = MostWantedPersonDataModel(
        uid = input.uid,
        id = input.id,
        rewardText = input.rewardText.orEmpty(),
        aliases = input.aliases.orEmpty(),
        publication = input.publication,
        url = input.url,
        warningMessage = input.warningMessage.orEmpty(),

        details = input.details.orEmpty(),

        occupations = input.occupations.orEmpty(),

        nationality = input.nationality.orEmpty(),

        placeOfBirth = input.placeOfBirth.orEmpty(),
        datesOfBirthUsed = input.datesOfBirthUsed.orEmpty(),

        languages = input.languages.orEmpty(),

        sex = input.sex?.let(sexApiToDataMapper::toData) ?: Unspecified,

        scarsAndMarks = input.scarsAndMarks.orEmpty(),
        complexion = input.complexion.orEmpty(),
        race = input.race.orEmpty(),
        raceRaw = input.raceRaw.orEmpty(),
        build = input.build.orEmpty(),
        hair = input.hair.orEmpty(),
        hairRaw = input.hairRaw.orEmpty(),
        eyes = input.eyes.orEmpty(),
        eyesRaw = input.eyesRaw.orEmpty(),

        ageMin = input.ageMin ?: 0,
        ageMax = input.ageMax ?: 0,
        ageRange = input.ageRange.orEmpty(),

        weight = input.weight.orEmpty(),
        weightMin = input.weightMin ?: 0,
        weightMax = input.weightMax ?: 0,

        heightMin = input.heightMin ?: 0,
        heightMax = input.heightMax ?: 0,

        rewardMin = input.rewardMin,
        rewardMax = input.rewardMax,

        files = input.files.map(fileApiToDataMapper::toData),
        images = input.images.map(imageApiToDataMapper::toData),

        title = input.title,
        description = input.description,
        status = statusApiToDataMapper.toData(input.status),
        remarks = input.remarks.orEmpty(),
        path = input.path,

        possibleStates = input.possibleStates.orEmpty(),
        possibleCountries = input.possibleCountries.orEmpty(),

        caution = input.caution.orEmpty(),
        modified = input.modified,

        subjects = input.subjects,

        ncic = input.ncic.orEmpty(),

        fieldOffices = input.fieldOffices.orEmpty()
    )
}
