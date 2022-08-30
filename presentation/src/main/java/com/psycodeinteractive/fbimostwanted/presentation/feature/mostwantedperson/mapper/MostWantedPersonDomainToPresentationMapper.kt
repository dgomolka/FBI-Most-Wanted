package com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper

import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.MostWantedPersonDomainModel
import com.psycodeinteractive.fbimostwanted.presentation.contract.mapper.DomainToPresentationMapper
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.model.MostWantedPersonPresentationModel

class MostWantedPersonDomainToPresentationMapper(

) : DomainToPresentationMapper<MostWantedPersonDomainModel, MostWantedPersonPresentationModel>() {
    override fun map(input: MostWantedPersonDomainModel) = MostWantedPersonPresentationModel(

    )
}
