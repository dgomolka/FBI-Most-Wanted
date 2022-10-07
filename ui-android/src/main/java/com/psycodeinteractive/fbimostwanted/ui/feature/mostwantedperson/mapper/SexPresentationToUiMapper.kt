package com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.mapper

import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.model.SexPresentationModel
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.model.SexPresentationModel.Female
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.model.SexPresentationModel.Male
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.model.SexPresentationModel.Unspecified
import com.psycodeinteractive.fbimostwanted.ui.contract.mapper.PresentationToUiMapper
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.model.SexUiModel

class SexPresentationToUiMapper : PresentationToUiMapper<SexPresentationModel, SexUiModel>() {
    override fun map(input: SexPresentationModel) = when (input) {
        Female -> SexUiModel.Female
        Male -> SexUiModel.Male
        Unspecified -> SexUiModel.Unspecified
    }
}
