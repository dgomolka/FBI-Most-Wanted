package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.local

import com.squareup.sqldelight.db.SqlDriver

const val AppDatabaseName = "MostWantedAppDatabase.db"

expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}
