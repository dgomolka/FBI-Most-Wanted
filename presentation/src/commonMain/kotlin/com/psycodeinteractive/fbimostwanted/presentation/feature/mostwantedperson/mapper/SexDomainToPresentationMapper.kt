package com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper

import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.SexDomainModel
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.SexDomainModel.Female
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.SexDomainModel.Male
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.SexDomainModel.Unspecified
import com.psycodeinteractive.fbimostwanted.presentation.contract.mapper.DomainToPresentationMapper
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.model.SexPresentationModel

class SexDomainToPresentationMapper : DomainToPresentationMapper<SexDomainModel, SexPresentationModel>() {
    override fun map(input: SexDomainModel) = when (input) {
        Female -> SexPresentationModel.Female
        Male -> SexPresentationModel.Male
        Unspecified -> SexPresentationModel.Unspecified
    }
}
