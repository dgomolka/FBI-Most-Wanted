package com.psycodeinteractive.fbimostwanted.presentation.feature.splash

import com.psycodeinteractive.fbimostwanted.presentation.BaseViewModel
import com.psycodeinteractive.fbimostwanted.presentation.execution.UseCaseExecutorProvider
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedlist.MostWantedListPresentationDestination
import com.psycodeinteractive.fbimostwanted.presentation.feature.splash.SplashEvent.StartSplash
import com.psycodeinteractive.fbimostwanted.presentation.mapper.DefaultDomainToPresentationExceptionMapper
import me.tatarka.inject.annotations.Inject

@Inject
class SplashViewModel(
    useCaseExecutorProvider: UseCaseExecutorProvider,
    defaultDomainToPresentationExceptionMapper: DefaultDomainToPresentationExceptionMapper
) : BaseViewModel<SplashViewState, SplashEvent>(
    useCaseExecutorProvider,
    defaultDomainToPresentationExceptionMapper
) {

    override val initialViewState = SplashViewState

    init {
        StartSplash.dispatchEvent()
    }

    fun onSplashFinished() {
        MostWantedListPresentationDestination.navigate()
    }
}
