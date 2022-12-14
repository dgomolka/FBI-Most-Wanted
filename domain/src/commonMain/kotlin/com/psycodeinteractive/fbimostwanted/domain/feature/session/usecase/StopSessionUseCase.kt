package com.psycodeinteractive.fbimostwanted.domain.feature.session.usecase

import com.psycodeinteractive.fbimostwanted.domain.coroutine.CoroutineContextProvider
import com.psycodeinteractive.fbimostwanted.domain.execution.usecase.BackgroundExecutionUseCase
import com.psycodeinteractive.fbimostwanted.domain.execution.usecase.BaseUseCase
import com.psycodeinteractive.fbimostwanted.domain.feature.session.repository.AppSessionRepository
import kotlinx.coroutines.CoroutineScope

interface StopSessionUseCase : BaseUseCase<Unit, Unit>

class StopSessionUseCaseImpl(
    private val appSessionRepository: AppSessionRepository,
    coroutineContextProvider: CoroutineContextProvider
) : StopSessionUseCase, BackgroundExecutionUseCase<Unit, Unit>(coroutineContextProvider) {
    override suspend fun executeInBackground(request: Unit, coroutineScope: CoroutineScope) =
        appSessionRepository.stopSession()
}
