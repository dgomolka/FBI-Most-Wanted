package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper

import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.FileDataModel
import com.psycodeinteractive.fbimostwanted.domain.contract.mapper.DataToDomainMapper
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.FileDomainModel

class FileDataToDomainMapper : DataToDomainMapper<FileDataModel, FileDomainModel>() {
    override fun map(input: FileDataModel) = FileDomainModel(
        url = input.url
    )
}
