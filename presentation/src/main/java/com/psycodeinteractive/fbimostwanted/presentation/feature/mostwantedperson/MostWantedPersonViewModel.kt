package com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson

import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.MostWantedPersonDomainModel
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.usecase.GetMostWantedPersonUseCase
import com.psycodeinteractive.fbimostwanted.presentation.BaseViewModel
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper.MostWantedPersonDomainToPresentationMapper

class MostWantedPersonViewModel(
    private val getMostWantedPersonUseCase: GetMostWantedPersonUseCase,
    private val mostWantedPersonDomainToPresentationMapper: MostWantedPersonDomainToPresentationMapper
) : BaseViewModel<MostWantedPersonViewState, MostWantedPersonEvent>() {

    override val initialViewState = MostWantedPersonViewState()

    fun fetchMostWantedPerson(personId: String) {
        getMostWantedPersonUseCase.execute(
            callback = ::updateMostWantedPersonState,
            value = personId
        )
    }

    fun onViewCreated(personId: String) {
        fetchMostWantedPerson(personId)
    }

    private fun updateMostWantedPersonState(mostWantedPersonDomainModel: MostWantedPersonDomainModel) {
        updateViewState {
            mostWantedPerson = mostWantedPersonDomainToPresentationMapper.toPresentation(
                mostWantedPersonDomainModel
            )
        }
    }
}
