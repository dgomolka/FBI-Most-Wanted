package com.psycodeinteractive.fbimostwanted.presentation.feature.splash

import com.psycodeinteractive.fbimostwanted.presentation.BaseViewModel
import com.psycodeinteractive.fbimostwanted.presentation.feature.splash.SplashEvent.SplashFinished
import com.psycodeinteractive.fbimostwanted.presentation.feature.splash.SplashEvent.StartSplash

class SplashViewModel : BaseViewModel<SplashViewState, SplashEvent>() {

    init {
        StartSplash.dispatch()
    }

    fun onSplashFinished() {
        SplashFinished.dispatch()
    }

    override fun getInitialViewState() = SplashViewState
}
