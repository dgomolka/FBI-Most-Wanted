package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper

import com.psycodeinteractive.fbimostwanted.data.contract.mapper.ApiToDataMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.ImageDataModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.remote.ImageApiModel

class ImageApiToDataMapper : ApiToDataMapper<ImageApiModel, ImageDataModel>() {
    override fun map(input: ImageApiModel) = ImageDataModel(
        original = input.original,
        thumb = input.thumb,
        large = input.large,
        caption = input.caption.orEmpty()
    )
}
