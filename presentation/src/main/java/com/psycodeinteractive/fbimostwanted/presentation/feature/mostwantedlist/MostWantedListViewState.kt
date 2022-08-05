package com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedlist

import com.psycodeinteractive.fbimostwanted.presentation.ViewState
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedlist.model.MostWantedPersonPresentationModel

data class MostWantedListViewState(
    val mostWantedPersonList: List<MostWantedPersonPresentationModel> = emptyList()
) : ViewState()
