package com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper

import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.StatusDomainModel
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.StatusDomainModel.Captured
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.StatusDomainModel.NotAvailable
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.StatusDomainModel.Recovered
import com.psycodeinteractive.fbimostwanted.presentation.contract.mapper.DomainToPresentationMapper
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.model.StatusPresentationModel

class StatusDomainToPresentationMapper : DomainToPresentationMapper<StatusDomainModel, StatusPresentationModel>() {
    override fun map(input: StatusDomainModel) = when (input) {
        Captured -> StatusPresentationModel.Captured
        NotAvailable -> StatusPresentationModel.NotAvailable
        Recovered -> StatusPresentationModel.Recovered
    }
}
