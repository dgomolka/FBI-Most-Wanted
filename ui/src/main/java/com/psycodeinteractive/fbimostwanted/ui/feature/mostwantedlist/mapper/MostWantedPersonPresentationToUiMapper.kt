package com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedlist.mapper

import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.model.MostWantedPersonPresentationModel
import com.psycodeinteractive.fbimostwanted.ui.contract.mapper.PresentationToUiMapper
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.model.MostWantedPersonUiModel

class MostWantedPersonPresentationToUiMapper(

) : PresentationToUiMapper<MostWantedPersonPresentationModel, MostWantedPersonUiModel>() {
    override fun map(input: MostWantedPersonPresentationModel) = MostWantedPersonUiModel(

    )
}
