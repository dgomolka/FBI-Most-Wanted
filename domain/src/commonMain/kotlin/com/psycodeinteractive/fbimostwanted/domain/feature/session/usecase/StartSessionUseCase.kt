package com.psycodeinteractive.fbimostwanted.domain.feature.session.usecase

import com.psycodeinteractive.fbimostwanted.domain.execution.usecase.BackgroundExecutionUseCase
import com.psycodeinteractive.fbimostwanted.domain.execution.usecase.BaseUseCase
import com.psycodeinteractive.fbimostwanted.domain.execution.usecase.CoroutineContextProvider
import com.psycodeinteractive.fbimostwanted.domain.feature.session.repository.AppSessionRepository
import kotlinx.coroutines.CoroutineScope

interface StartSessionUseCase : BaseUseCase<Unit, Unit>

class StartSessionUseCaseImpl(
    private val appSessionRepository: AppSessionRepository,
    coroutineContextProvider: CoroutineContextProvider
) : StartSessionUseCase, BackgroundExecutionUseCase<Unit, Unit>(coroutineContextProvider) {
    override suspend fun executeInBackground(request: Unit, coroutineScope: CoroutineScope) =
        appSessionRepository.startSession()
}
