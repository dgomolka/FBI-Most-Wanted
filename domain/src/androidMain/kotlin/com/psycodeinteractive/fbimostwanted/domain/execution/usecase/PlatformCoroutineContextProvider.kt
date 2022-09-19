package com.psycodeinteractive.fbimostwanted.domain.execution.usecase

import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

actual object PlatformCoroutineContextProvider : CoroutineContextProvider {
    override val main by lazy { Main }
    override val io by lazy { IO }
}
