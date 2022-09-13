package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.local

import com.psycodeinteractive.fbimostwanted.data.source.local.MostWantedAppDatabase
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver = NativeSqliteDriver(MostWantedAppDatabase.Schema, AppDatabaseName)
}
