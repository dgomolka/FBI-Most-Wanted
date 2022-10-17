package com.psycodeinteractive.fbimostwanted.presentation.feature.splash

import com.psycodeinteractive.fbimostwanted.domain.logger.Logger
import com.psycodeinteractive.fbimostwanted.presentation.BaseViewModel
import com.psycodeinteractive.fbimostwanted.presentation.execution.UseCaseExecutorProvider
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedlist.MostWantedListPresentationDestination
import com.psycodeinteractive.fbimostwanted.presentation.feature.splash.SplashEvent.StartSplash
import com.psycodeinteractive.fbimostwanted.presentation.mapper.DefaultDomainToPresentationExceptionMapper
import me.tatarka.inject.annotations.Inject

@Inject
class SplashViewModel(
    useCaseExecutorProvider: UseCaseExecutorProvider,
    defaultDomainToPresentationExceptionMapper: DefaultDomainToPresentationExceptionMapper,
    logger: Logger
) : BaseViewModel<SplashViewState, SplashEvent>(
    useCaseExecutorProvider,
    defaultDomainToPresentationExceptionMapper,
    logger
) {

    override val initialViewState = SplashViewState

    fun onViewCreated() {
        StartSplash.dispatchEvent()
    }

    fun onSplashFinished() {
        MostWantedListPresentationDestination.navigate()
    }
}
