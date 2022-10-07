package com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper

import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.FileDomainModel
import com.psycodeinteractive.fbimostwanted.presentation.contract.mapper.DomainToPresentationMapper
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.model.FilePresentationModel

class FileDomainToPresentationMapper : DomainToPresentationMapper<FileDomainModel, FilePresentationModel>() {
    override fun map(input: FileDomainModel) = FilePresentationModel(
        url = input.url
    )
}
