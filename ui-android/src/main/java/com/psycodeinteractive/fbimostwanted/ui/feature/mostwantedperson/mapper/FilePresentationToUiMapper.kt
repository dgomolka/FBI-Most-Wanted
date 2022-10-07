package com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.mapper

import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.model.FilePresentationModel
import com.psycodeinteractive.fbimostwanted.ui.contract.mapper.PresentationToUiMapper
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.model.FileUiModel

class FilePresentationToUiMapper : PresentationToUiMapper<FilePresentationModel, FileUiModel>() {
    override fun map(input: FilePresentationModel) = FileUiModel(
        url = input.url
    )
}
