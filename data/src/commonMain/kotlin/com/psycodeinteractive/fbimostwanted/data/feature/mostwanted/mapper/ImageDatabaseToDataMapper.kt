package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper

import com.psycodeinteractive.fbimostwanted.data.contract.mapper.DatabaseToDataMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.ImageDataModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.local.ImageDatabaseModel

class ImageDatabaseToDataMapper : DatabaseToDataMapper<ImageDatabaseModel, ImageDataModel>() {
    override fun map(input: ImageDatabaseModel) = ImageDataModel(
        original = input.original,
        thumb = input.thumb,
        large = input.large,
        caption = input.caption
    )
}
