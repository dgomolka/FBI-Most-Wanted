package com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedlist.mapper

import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.MostWantedPersonPresentationDestination
import com.psycodeinteractive.fbimostwanted.presentation.navigation.PresentationDestination
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedlist.MostWantedListScreenNavigationCallbacks
import com.psycodeinteractive.fbimostwanted.ui.screen.PresentationDestinationToNavigationCallbackMapper

class MostWantedListScreenPresentationDestinationToNavigationCallbackMapper :
    PresentationDestinationToNavigationCallbackMapper<MostWantedListScreenNavigationCallbacks> {
    override fun map(
        destination: PresentationDestination,
        screenNavigationCallbacks: MostWantedListScreenNavigationCallbacks
    ) = when (destination) {
        is MostWantedPersonPresentationDestination -> screenNavigationCallbacks.goToPersonDetails(destination.personId)
        else -> {}
    }
}
