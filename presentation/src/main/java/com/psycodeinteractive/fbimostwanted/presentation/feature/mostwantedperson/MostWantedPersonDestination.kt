package com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson

import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.MostWantedPersonDestination.Argument.PersonId
import com.psycodeinteractive.fbimostwanted.presentation.navigation.Destination
import com.psycodeinteractive.fbimostwanted.presentation.navigation.DestinationArgument

class MostWantedPersonDestination(val personId: Long) : Destination(
    PersonId to personId
) {
    enum class Argument : DestinationArgument {
        PersonId
    }
}
