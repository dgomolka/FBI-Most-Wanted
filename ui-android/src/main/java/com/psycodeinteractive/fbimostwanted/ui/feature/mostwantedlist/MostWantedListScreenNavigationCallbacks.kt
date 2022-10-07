package com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedlist

import com.psycodeinteractive.fbimostwanted.ui.screen.ScreenNavigationCallbacks

data class MostWantedListScreenNavigationCallbacks(
    val goToPersonDetails: (personId: String) -> Unit
) : ScreenNavigationCallbacks
