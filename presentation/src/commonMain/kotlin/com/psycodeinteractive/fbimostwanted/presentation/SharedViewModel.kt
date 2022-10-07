package com.psycodeinteractive.fbimostwanted.presentation

import kotlinx.coroutines.CoroutineScope

expect abstract class SharedViewModel() {
    val viewModelScope: CoroutineScope

    protected open fun onCleared()
}
