package com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.usecase

import com.psycodeinteractive.fbimostwanted.domain.coroutine.CoroutineContextProvider
import com.psycodeinteractive.fbimostwanted.domain.execution.usecase.BackgroundExecutionUseCase
import com.psycodeinteractive.fbimostwanted.domain.execution.usecase.BaseUseCase
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.MostWantedPersonDomainModel
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.repository.MostWantedRepository
import kotlinx.coroutines.CoroutineScope

interface GetMostWantedPersonUseCase : BaseUseCase<String, MostWantedPersonDomainModel>

class GetMostWantedPersonUseCaseImpl(
    private val mostWantedRepository: MostWantedRepository,
    coroutineContextProvider: CoroutineContextProvider
) : GetMostWantedPersonUseCase, BackgroundExecutionUseCase<String, MostWantedPersonDomainModel>(coroutineContextProvider) {
    override suspend fun executeInBackground(request: String, coroutineScope: CoroutineScope) =
        mostWantedRepository.getMostWantedPerson(request)
}
