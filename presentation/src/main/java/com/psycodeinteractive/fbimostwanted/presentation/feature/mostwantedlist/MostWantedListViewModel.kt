package com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedlist

import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.MostWantedPersonDomainModel
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.usecase.GetMostWantedListUseCase
import com.psycodeinteractive.fbimostwanted.presentation.BaseViewModel
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper.MostWantedPersonDomainToPresentationMapper

class MostWantedListViewModel(
    private val getMostWantedListUseCase: GetMostWantedListUseCase,
    private val mostWantedPersonDomainToPresentationMapper: MostWantedPersonDomainToPresentationMapper
) : BaseViewModel<MostWantedListViewState, MostWantedListEvent>() {

    init {
        fetchMostWantedList()
    }

    override fun getInitialViewState() = MostWantedListViewState()

    fun fetchMostWantedList() {
        getMostWantedListUseCase.execute(
            callback = ::updateMostWantedPersonListState
        )
    }

    private fun updateMostWantedPersonListState(mostWantedPersonDomainList: List<MostWantedPersonDomainModel>) {
        updateViewState {
            mostWantedPersonList = mostWantedPersonDomainList.map(mostWantedPersonDomainToPresentationMapper::toPresentation)
        }
    }

    fun onMostWantedPersonClick(personId: Long) {
        MostWantedPersonDestination(personId).navigate()
    }
}
