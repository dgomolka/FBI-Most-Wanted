package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper

import com.psycodeinteractive.fbimostwanted.data.contract.mapper.DataToDatabaseMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.FileDataModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.local.FileDatabaseModel

class FileDataToDatabaseMapper : DataToDatabaseMapper<FileDataModel, FileDatabaseModel>() {
    override fun map(input: FileDataModel) = FileDatabaseModel(
        url = input.url
    )
}
