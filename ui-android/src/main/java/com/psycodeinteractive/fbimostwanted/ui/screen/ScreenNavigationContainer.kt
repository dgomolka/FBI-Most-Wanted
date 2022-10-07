package com.psycodeinteractive.fbimostwanted.ui.screen

data class ScreenNavigationContainer<Callbacks : ScreenNavigationCallbacks>(
    val screenNavigationCallbacks: Callbacks,
    val presentationDestinationToNavigationCallbackMapper: PresentationDestinationToNavigationCallbackMapper<Callbacks>
)
