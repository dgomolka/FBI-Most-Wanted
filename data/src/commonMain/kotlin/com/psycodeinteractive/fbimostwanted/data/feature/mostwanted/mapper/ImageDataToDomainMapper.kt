package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper

import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.ImageDataModel
import com.psycodeinteractive.fbimostwanted.domain.contract.mapper.DataToDomainMapper
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.ImageDomainModel

class ImageDataToDomainMapper : DataToDomainMapper<ImageDataModel, ImageDomainModel>() {
    override fun map(input: ImageDataModel) = ImageDomainModel(
        original = input.original,
        thumb = input.thumb,
        large = input.large,
        caption = input.caption
    )
}
