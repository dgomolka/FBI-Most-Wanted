package com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson

import com.psycodeinteractive.fbimostwanted.presentation.ViewState
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedlist.model.MostWantedPersonPresentationModel

data class MostWantedPersonViewState(
    var mostWantedPerson: MostWantedPersonPresentationModel? = null
) : ViewState()
