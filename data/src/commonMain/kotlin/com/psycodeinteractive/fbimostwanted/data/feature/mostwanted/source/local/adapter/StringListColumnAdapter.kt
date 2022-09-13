package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.local.adapter

import kotlinx.serialization.builtins.serializer

object StringListColumnAdapter : SerializableListColumnAdapter<String>(String.serializer())
