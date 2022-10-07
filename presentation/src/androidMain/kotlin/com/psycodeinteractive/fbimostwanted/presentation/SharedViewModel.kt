package com.psycodeinteractive.fbimostwanted.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope as androidViewModelScope

actual abstract class SharedViewModel : ViewModel() {
    actual val viewModelScope = androidViewModelScope

    actual override fun onCleared() {}
}
