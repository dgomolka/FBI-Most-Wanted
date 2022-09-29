package com.psycodeinteractive.fbimostwanted.ui.feature.splash.mapper

import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedlist.MostWantedListPresentationDestination
import com.psycodeinteractive.fbimostwanted.presentation.navigation.PresentationDestination
import com.psycodeinteractive.fbimostwanted.ui.feature.splash.SplashScreenNavigationCallbacks
import com.psycodeinteractive.fbimostwanted.ui.screen.PresentationDestinationToNavigationCallbackMapper

class SplashScreenPresentationDestinationToNavigationCallbackMapper :
    PresentationDestinationToNavigationCallbackMapper<SplashScreenNavigationCallbacks> {
    override fun map(destination: PresentationDestination, screenNavigationCallbacks: SplashScreenNavigationCallbacks) = when (destination) {
        is MostWantedListPresentationDestination -> screenNavigationCallbacks.goToMostWantedList()
        else -> {}
    }
}
