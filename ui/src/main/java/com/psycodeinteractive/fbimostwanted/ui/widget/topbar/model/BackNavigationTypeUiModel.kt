package com.psycodeinteractive.fbimostwanted.ui.widget.topbar.model

import androidx.annotation.DrawableRes
import com.psycodeinteractive.fbimostwanted.ui.R

sealed class BackNavigationTypeUiModel(
    @DrawableRes val iconResource: Int = 0
) {
    object Close : BackNavigationTypeUiModel(iconResource = R.drawable.icon_close)
    object None : BackNavigationTypeUiModel()
}
