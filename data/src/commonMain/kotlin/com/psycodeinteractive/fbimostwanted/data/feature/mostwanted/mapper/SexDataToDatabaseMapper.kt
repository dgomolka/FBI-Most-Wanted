package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper

import com.psycodeinteractive.fbimostwanted.data.contract.mapper.DataToDatabaseMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.SexDataModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.SexDataModel.Female
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.SexDataModel.Male
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.SexDataModel.Unspecified
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.local.SexDatabaseModel

class SexDataToDatabaseMapper : DataToDatabaseMapper<SexDataModel, SexDatabaseModel>() {
    override fun map(input: SexDataModel) = when (input) {
        Female -> SexDatabaseModel.Female
        Male -> SexDatabaseModel.Male
        Unspecified -> SexDatabaseModel.Unspecified
    }
}
