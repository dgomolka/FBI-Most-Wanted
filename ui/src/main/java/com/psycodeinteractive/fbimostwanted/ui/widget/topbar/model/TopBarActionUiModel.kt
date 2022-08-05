package com.psycodeinteractive.fbimostwanted.ui.widget.topbar.model

import androidx.annotation.StringRes
import com.psycodeinteractive.fbimostwanted.ui.R

sealed class TopBarActionUiModel(
    @StringRes val textResource: Int = 0
) {
    object Save : TopBarActionUiModel(textResource = R.string.save)
    object None : TopBarActionUiModel()
}
