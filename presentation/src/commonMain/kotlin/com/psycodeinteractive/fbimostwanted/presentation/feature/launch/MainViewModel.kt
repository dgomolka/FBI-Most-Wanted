package com.psycodeinteractive.fbimostwanted.presentation.feature.launch

import com.psycodeinteractive.fbimostwanted.domain.feature.session.usecase.StartSessionUseCase
import com.psycodeinteractive.fbimostwanted.domain.feature.session.usecase.StopSessionUseCase
import com.psycodeinteractive.fbimostwanted.presentation.BaseViewModel
import com.psycodeinteractive.fbimostwanted.presentation.execution.UseCaseExecutorProvider
import com.psycodeinteractive.fbimostwanted.presentation.mapper.DefaultDomainToPresentationExceptionMapper
import me.tatarka.inject.annotations.Inject

@Inject
class MainViewModel(
    private val startSessionUseCase: StartSessionUseCase,
    private val stopSessionUseCase: StopSessionUseCase,
    useCaseExecutorProvider: UseCaseExecutorProvider,
    defaultDomainToPresentationExceptionMapper: DefaultDomainToPresentationExceptionMapper
) : BaseViewModel<LaunchViewState, LaunchEvent>(
    useCaseExecutorProvider,
    defaultDomainToPresentationExceptionMapper
) {

    override val initialViewState = LaunchViewState

    fun onStart() {
        startSessionUseCase.execute()
    }

    fun onStop() {
        stopSessionUseCase.execute()
    }
}
