package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.local

import android.content.Context
import com.psycodeinteractive.fbimostwanted.data.source.local.MostWantedAppDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver = AndroidSqliteDriver(MostWantedAppDatabase.Schema, context, AppDatabaseName)
}
