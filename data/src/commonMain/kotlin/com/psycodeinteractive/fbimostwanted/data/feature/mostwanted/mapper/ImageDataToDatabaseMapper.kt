package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper

import com.psycodeinteractive.fbimostwanted.data.contract.mapper.DataToDatabaseMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.ImageDataModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.local.ImageDatabaseModel

class ImageDataToDatabaseMapper : DataToDatabaseMapper<ImageDataModel, ImageDatabaseModel>() {
    override fun map(input: ImageDataModel) = ImageDatabaseModel(
        original = input.original,
        thumb = input.thumb,
        large = input.large,
        caption = input.caption
    )
}
