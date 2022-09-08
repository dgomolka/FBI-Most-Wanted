package com.psycodeinteractive.fbimostwanted.presentation.navigation

abstract class Destination(vararg val arguments: Pair<DestinationArgument, Any> = emptyArray()) {
    open fun argumentsAsPath() = "/" + arguments.joinToString(separator = "&") { pair -> "${pair.first}?=${pair.second}" }
}
