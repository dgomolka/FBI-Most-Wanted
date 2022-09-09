package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper

import com.psycodeinteractive.fbimostwanted.data.contract.mapper.ApiToDataMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.StatusDataModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.remote.StatusApiModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.remote.StatusApiModel.Captured
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.remote.StatusApiModel.NotAvailable
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.remote.StatusApiModel.Recovered

class StatusApiToDataMapper : ApiToDataMapper<StatusApiModel, StatusDataModel>() {
    override fun map(input: StatusApiModel) = when (input) {
        Captured -> StatusDataModel.Captured
        NotAvailable -> StatusDataModel.NotAvailable
        Recovered -> StatusDataModel.Recovered
    }
}
