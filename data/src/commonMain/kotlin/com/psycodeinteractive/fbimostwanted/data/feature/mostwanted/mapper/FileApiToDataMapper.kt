package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper

import com.psycodeinteractive.fbimostwanted.data.contract.mapper.ApiToDataMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.FileDataModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.remote.FileApiModel

class FileApiToDataMapper : ApiToDataMapper<FileApiModel, FileDataModel>() {
    override fun map(input: FileApiModel) = FileDataModel(
        url = input.url
    )
}
