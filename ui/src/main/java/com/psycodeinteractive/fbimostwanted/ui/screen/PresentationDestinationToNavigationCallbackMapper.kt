package com.psycodeinteractive.fbimostwanted.ui.screen

import com.psycodeinteractive.fbimostwanted.presentation.navigation.PresentationDestination

interface PresentationDestinationToNavigationCallbackMapper<Callbacks : ScreenNavigationCallbacks> {
    fun map(destination: PresentationDestination, screenNavigationCallbacks: Callbacks): Any
}
