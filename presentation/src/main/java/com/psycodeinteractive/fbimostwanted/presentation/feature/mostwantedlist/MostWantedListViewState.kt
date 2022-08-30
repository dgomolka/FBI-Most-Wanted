package com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedlist

import com.psycodeinteractive.fbimostwanted.presentation.ViewState
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.model.MostWantedPersonPresentationModel

data class MostWantedListViewState(
    var mostWantedPersonList: List<MostWantedPersonPresentationModel> = emptyList()
) : ViewState()
