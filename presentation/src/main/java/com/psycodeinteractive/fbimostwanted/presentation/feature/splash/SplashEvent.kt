package com.psycodeinteractive.fbimostwanted.presentation.feature.splash

import com.psycodeinteractive.fbimostwanted.presentation.Event

sealed class SplashEvent : Event {
    object StartSplash : SplashEvent()
}
