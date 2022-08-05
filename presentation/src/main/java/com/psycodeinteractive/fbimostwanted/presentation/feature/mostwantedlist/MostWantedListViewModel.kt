package com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedlist

import com.psycodeinteractive.fbimostwanted.presentation.BaseViewModel

class MostWantedListViewModel : BaseViewModel<MostWantedListViewState, MostWantedListEvent>() {

    init {

    }

    fun onMostWantedPersonClick(personId: Long) {

    }

    override fun getInitialState() = MostWantedListViewState()
}
