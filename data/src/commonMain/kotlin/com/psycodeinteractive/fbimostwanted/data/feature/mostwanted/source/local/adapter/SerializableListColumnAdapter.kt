package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.local.adapter

import com.squareup.sqldelight.ColumnAdapter
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

open class SerializableListColumnAdapter<DatabaseModel : Any> (
    private val serializer: KSerializer<DatabaseModel>
) : ColumnAdapter<List<DatabaseModel>, String> {
    override fun decode(databaseValue: String) = Json.decodeFromString(ListSerializer(serializer), databaseValue)

    override fun encode(value: List<DatabaseModel>) = Json.encodeToString(ListSerializer(serializer), value)
}
