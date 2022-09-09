package com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.mapper

import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.model.StatusPresentationModel
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.model.StatusPresentationModel.Captured
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.model.StatusPresentationModel.NotAvailable
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.model.StatusPresentationModel.Recovered
import com.psycodeinteractive.fbimostwanted.ui.contract.mapper.PresentationToUiMapper
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.model.StatusUiModel

class StatusPresentationToUiMapper : PresentationToUiMapper<StatusPresentationModel, StatusUiModel>() {
    override fun map(input: StatusPresentationModel) = when (input) {
        Captured -> StatusUiModel.Captured
        NotAvailable -> StatusUiModel.NotAvailable
        Recovered -> StatusUiModel.Recovered
    }
}
