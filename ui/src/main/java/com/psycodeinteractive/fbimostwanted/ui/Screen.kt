package com.psycodeinteractive.fbimostwanted.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Lifecycle.State.STARTED
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import com.psycodeinteractive.fbimostwanted.presentation.BaseViewModel
import com.psycodeinteractive.fbimostwanted.presentation.Event
import com.psycodeinteractive.fbimostwanted.presentation.ViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

@Composable
inline fun <reified VM : BaseViewModel<out ViewState, out Event>> Screen(
    crossinline provideViewModel: () -> VM,
    crossinline children: @Composable (viewModel: VM, lifecycleScope: LifecycleCoroutineScope) -> Unit
) {
    val viewModel: VM = viewModel { provideViewModel() }
    children(viewModel, LocalLifecycleOwner.current.lifecycleScope)
}

@Composable
inline fun <reified VM : ViewModel> viewModel(
    viewModelStoreOwner: ViewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current) {
        "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner"
    },
    key: String? = null,
    crossinline factory: () -> VM
): VM = androidx.lifecycle.viewmodel.compose.viewModel(
    viewModelStoreOwner = viewModelStoreOwner,
    key = key,
    factory = object : ViewModelProvider.Factory {
        override fun <VM : ViewModel> create(modelClass: Class<VM>): VM = factory() as VM
    }
)

@Composable
inline fun <VM : BaseViewModel<VS, out Event>, reified VS : ViewState>
VM.collectViewState(): MutableState<VS> {
    val composeState = viewState.collectAsState(initialViewState.wrap())
    val newState = remember { mutableStateOf(initialViewState) }
    newState.value = composeState.value.state
    return newState
}

@Composable
inline fun <reified Model> Flow<Model>.observeWithLifecycle(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    minActiveState: Lifecycle.State = STARTED,
    noinline action: suspend (Model) -> Unit
) {
    OnLifecycle(lifecycleOwner, minActiveState) {
        flowWithLifecycle(lifecycleOwner.lifecycle, minActiveState).collect { value -> action(value) }
    }
}

@Composable
fun OnLifecycle(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    minActiveState: Lifecycle.State = STARTED,
    action: suspend () -> Unit
) {
    LaunchedEffect(key1 = Unit) {
        with(lifecycleOwner) {
            lifecycleScope.launch {
                repeatOnLifecycle(minActiveState) {
                    action()
                }
            }
        }
    }
}
