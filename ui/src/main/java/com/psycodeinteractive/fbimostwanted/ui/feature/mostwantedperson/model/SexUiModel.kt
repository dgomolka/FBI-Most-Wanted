package com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.model

import androidx.annotation.StringRes
import com.psycodeinteractive.fbimostwanted.ui.R

enum class SexUiModel(
    @StringRes val stringResource: Int
) {
    Female(R.string.female),
    Male(R.string.male),
    Unspecified(R.string.unspecified)
}
