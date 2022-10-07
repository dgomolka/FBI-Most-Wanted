package com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedlist

import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.MostWantedPersonDomainModel
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.usecase.GetMostWantedListUseCase
import com.psycodeinteractive.fbimostwanted.presentation.BaseViewModel
import com.psycodeinteractive.fbimostwanted.presentation.execution.UseCaseExecutorProvider
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.MostWantedPersonPresentationDestination
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.mapper.MostWantedPersonDomainToPresentationMapper
import com.psycodeinteractive.fbimostwanted.presentation.mapper.DefaultDomainToPresentationExceptionMapper
import me.tatarka.inject.annotations.Inject

@Inject
class MostWantedListViewModel(
    private val mostWantedPersonDomainToPresentationMapper: MostWantedPersonDomainToPresentationMapper,
    private val getMostWantedListUseCase: GetMostWantedListUseCase,
    useCaseExecutorProvider: UseCaseExecutorProvider,
    defaultDomainToPresentationExceptionMapper: DefaultDomainToPresentationExceptionMapper
) : BaseViewModel<MostWantedListViewState, MostWantedListEvent>(
    useCaseExecutorProvider,
    defaultDomainToPresentationExceptionMapper
) {

    override val initialViewState = MostWantedListViewState()

    init {
        fetchMostWantedList()
    }

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

    fun onMostWantedPersonClick(personId: String) {
        MostWantedPersonPresentationDestination(personId).navigate()
    }
}
