package com.psycodeinteractive.fbimostwanted.domain.coroutine

import kotlinx.coroutines.Dispatchers

actual object PlatformCoroutineContextProvider : CoroutineContextProvider {
    override val main by lazy { Dispatchers.Main }
    override val io by lazy { Dispatchers.IO }
}
