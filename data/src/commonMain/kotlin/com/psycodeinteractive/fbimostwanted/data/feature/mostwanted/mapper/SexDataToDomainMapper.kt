package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper

import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.SexDataModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.SexDataModel.Female
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.SexDataModel.Male
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.SexDataModel.Unspecified
import com.psycodeinteractive.fbimostwanted.domain.contract.mapper.DataToDomainMapper
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.SexDomainModel

class SexDataToDomainMapper : DataToDomainMapper<SexDataModel, SexDomainModel>() {
    override fun map(input: SexDataModel) = when (input) {
        Female -> SexDomainModel.Female
        Male -> SexDomainModel.Male
        Unspecified -> SexDomainModel.Unspecified
    }
}
