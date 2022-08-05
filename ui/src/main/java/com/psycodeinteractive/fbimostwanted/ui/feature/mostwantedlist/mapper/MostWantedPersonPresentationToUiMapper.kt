package com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedlist.mapper

import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedlist.model.MostWantedPersonPresentationModel
import com.psycodeinteractive.fbimostwanted.ui.contract.mapper.PresentationToUiMapper
import com.psycodeinteractive.fbimostwanted.ui.feature.persondetails.model.MostWantedPersonUiModel

class MostWantedPersonPresentationToUiMapper(

) : PresentationToUiMapper<MostWantedPersonPresentationModel, MostWantedPersonUiModel>() {
    override fun map(input: MostWantedPersonPresentationModel) = MostWantedPersonUiModel(

    )
}
