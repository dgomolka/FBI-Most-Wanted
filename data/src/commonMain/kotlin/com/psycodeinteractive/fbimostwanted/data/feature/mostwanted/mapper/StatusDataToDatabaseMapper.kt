package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper

import com.psycodeinteractive.fbimostwanted.data.contract.mapper.DataToDatabaseMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.StatusDataModel
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.StatusDataModel.Captured
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.StatusDataModel.NotAvailable
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.StatusDataModel.Recovered
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.model.local.StatusDatabaseModel

class StatusDataToDatabaseMapper : DataToDatabaseMapper<StatusDataModel, StatusDatabaseModel>() {
    override fun map(input: StatusDataModel) = when (input) {
        Captured -> StatusDatabaseModel.Captured
        NotAvailable -> StatusDatabaseModel.NotAvailable
        Recovered -> StatusDatabaseModel.Recovered
    }
}
