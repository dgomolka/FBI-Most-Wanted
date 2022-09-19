package com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedlist

import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.MostWantedPersonDomainModel
import com.psycodeinteractive.fbimostwanted.presentation.BaseViewModel
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.MostWantedPersonDestination
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper.MostWantedPersonDomainToPresentationMapper
import me.tatarka.inject.annotations.Inject

@Inject
class MostWantedListViewModel(
    private val mostWantedPersonDomainToPresentationMapper: MostWantedPersonDomainToPresentationMapper
//    private val getMostWantedListUseCase: GetMostWantedListUseCase
) : BaseViewModel<MostWantedListViewState, MostWantedListEvent>() {

    override val initialViewState = MostWantedListViewState()

    init {
        fetchMostWantedList()
    }

    fun fetchMostWantedList() {
//        getMostWantedListUseCase.execute(
//            callback = ::updateMostWantedPersonListState
//        )
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
