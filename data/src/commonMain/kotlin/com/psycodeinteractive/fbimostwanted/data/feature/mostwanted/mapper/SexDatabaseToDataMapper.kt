package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper

import com.psycodeinteractive.fbimostwanted.data.contract.mapper.DatabaseToDataMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.SexDataModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.local.SexDatabaseModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.local.SexDatabaseModel.Female
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.local.SexDatabaseModel.Male
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.local.SexDatabaseModel.Unspecified

class SexDatabaseToDataMapper : DatabaseToDataMapper<SexDatabaseModel, SexDataModel>() {
    override fun map(input: SexDatabaseModel) = when (input) {
        Female -> SexDataModel.Female
        Male -> SexDataModel.Male
        Unspecified -> SexDataModel.Unspecified
    }
}
