package com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.usecase

import com.psycodeinteractive.fbimostwanted.domain.execution.usecase.BackgroundExecutionUseCase
import com.psycodeinteractive.fbimostwanted.domain.execution.usecase.BaseUseCase
import com.psycodeinteractive.fbimostwanted.domain.execution.usecase.CoroutineContextProvider
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.MostWantedPersonDomainModel
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.repository.MostWantedRepository
import kotlinx.coroutines.CoroutineScope

interface GetMostWantedListUseCase : BaseUseCase<Unit, List<MostWantedPersonDomainModel>>

class GetMostWantedListUseCaseImpl(
    private val mostWantedRepository: MostWantedRepository,
    coroutineContextProvider: CoroutineContextProvider
) : GetMostWantedListUseCase, BackgroundExecutionUseCase<Unit, List<MostWantedPersonDomainModel>>(coroutineContextProvider) {
    override suspend fun executeInBackground(request: Unit, coroutineScope: CoroutineScope) =
        mostWantedRepository.getMostWantedList()
}
