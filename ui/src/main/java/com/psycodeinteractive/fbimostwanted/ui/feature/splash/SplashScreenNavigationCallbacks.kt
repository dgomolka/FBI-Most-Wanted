package com.psycodeinteractive.fbimostwanted.ui.feature.splash

import com.psycodeinteractive.fbimostwanted.ui.screen.ScreenNavigationCallbacks

data class SplashScreenNavigationCallbacks(
    val goToMostWantedList: () -> Unit
) : ScreenNavigationCallbacks
