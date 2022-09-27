package com.psycodeinteractive.fbimostwanted.ui.extension

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

val @receiver:StringRes Int.string: String
    @Composable get() = stringResource(id = this)
