package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper

import com.psycodeinteractive.fbimostwanted.data.contract.mapper.DatabaseToDataMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.StatusDataModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.local.StatusDatabaseModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.local.StatusDatabaseModel.Captured
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.local.StatusDatabaseModel.NotAvailable
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.local.StatusDatabaseModel.Recovered

class StatusDatabaseToDataMapper : DatabaseToDataMapper<StatusDatabaseModel, StatusDataModel>() {
    override fun map(input: StatusDatabaseModel) = when (input) {
        Captured -> StatusDataModel.Captured
        NotAvailable -> StatusDataModel.NotAvailable
        Recovered -> StatusDataModel.Recovered
    }
}
