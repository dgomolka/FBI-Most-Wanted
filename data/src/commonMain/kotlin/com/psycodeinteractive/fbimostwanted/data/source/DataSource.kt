package com.psycodeinteractive.fbimostwanted.data.source

import kotlinx.coroutines.flow.Flow

interface DataSource<DataModel> {
    fun refresh()
    suspend fun get(): Flow<DataModel>
}
