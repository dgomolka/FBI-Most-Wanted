package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper

import com.psycodeinteractive.fbimostwanted.data.contract.mapper.ApiToDataMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.SexDataModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.remote.SexApiModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.remote.SexApiModel.Female
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.remote.SexApiModel.Male

class SexApiToDataMapper : ApiToDataMapper<SexApiModel, SexDataModel>() {
    override fun map(input: SexApiModel) = when (input) {
        Female -> SexDataModel.Female
        Male -> SexDataModel.Male
    }
}
