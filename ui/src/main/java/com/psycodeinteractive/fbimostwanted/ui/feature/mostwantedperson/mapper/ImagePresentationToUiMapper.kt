package com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.mapper

import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.model.ImagePresentationModel
import com.psycodeinteractive.fbimostwanted.ui.contract.mapper.PresentationToUiMapper
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.model.ImageUiModel

class ImagePresentationToUiMapper : PresentationToUiMapper<ImagePresentationModel, ImageUiModel>() {
    override fun map(input: ImagePresentationModel) = ImageUiModel(
        original = input.original,
        thumb = input.thumb,
        large = input.large,
        caption = input.caption
    )
}
