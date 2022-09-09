package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper

import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.StatusDataModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.StatusDataModel.Captured
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.StatusDataModel.NotAvailable
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.StatusDataModel.Recovered
import com.psycodeinteractive.fbimostwanted.domain.contract.mapper.DataToDomainMapper
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.StatusDomainModel

class StatusDataToDomainMapper : DataToDomainMapper<StatusDataModel, StatusDomainModel>() {
    override fun map(input: StatusDataModel) = when (input) {
        Captured -> StatusDomainModel.Captured
        NotAvailable -> StatusDomainModel.NotAvailable
        Recovered -> StatusDomainModel.Recovered
    }
}
