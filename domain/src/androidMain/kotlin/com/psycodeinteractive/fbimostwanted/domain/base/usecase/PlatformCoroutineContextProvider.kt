package com.psycodeinteractive.fbimostwanted.domain.base.usecase

import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

actual class PlatformCoroutineContextProvider : CoroutineContextProvider {
    override val main by lazy { Main }
    override val io by lazy { IO }
}
