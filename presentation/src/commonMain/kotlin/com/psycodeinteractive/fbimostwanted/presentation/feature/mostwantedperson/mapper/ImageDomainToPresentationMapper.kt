package com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper

import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.ImageDomainModel
import com.psycodeinteractive.fbimostwanted.presentation.contract.mapper.DomainToPresentationMapper
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.model.ImagePresentationModel

interface ImageDomainToPresentationMapper : DomainToPresentationMapper<ImageDomainModel, ImagePresentationModel>

class ImageDomainToPresentationMapperImpl : ImageDomainToPresentationMapper {
    override fun map(input: ImageDomainModel) = ImagePresentationModel(
        original = input.original,
        thumb = input.thumb,
        large = input.large,
        caption = input.caption
    )
}
