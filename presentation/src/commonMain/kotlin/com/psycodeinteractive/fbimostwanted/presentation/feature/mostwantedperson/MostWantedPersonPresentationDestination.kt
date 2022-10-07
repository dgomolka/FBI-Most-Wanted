package com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson

import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.MostWantedPersonPresentationDestination.Argument.PersonId
import com.psycodeinteractive.fbimostwanted.presentation.navigation.DestinationArgument
import com.psycodeinteractive.fbimostwanted.presentation.navigation.PresentationDestination

class MostWantedPersonPresentationDestination(val personId: String) : PresentationDestination(
    PersonId to personId
) {
    enum class Argument : DestinationArgument {
        PersonId
    }
}
