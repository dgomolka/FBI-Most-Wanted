package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper

import com.psycodeinteractive.fbimostwanted.data.contract.mapper.DatabaseToDataMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.FileDataModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.local.FileDatabaseModel

class FileDatabaseToDataMapper : DatabaseToDataMapper<FileDatabaseModel, FileDataModel>() {
    override fun map(input: FileDatabaseModel) = FileDataModel(
        url = input.url
    )
}
