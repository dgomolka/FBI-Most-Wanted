package com.psycodeinteractive.fbimostwanted.ui.feature.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import com.psycodeinteractive.fbimostwanted.presentation.feature.splash.SplashEvent.StartSplash
import com.psycodeinteractive.fbimostwanted.presentation.feature.splash.SplashViewModel
import com.psycodeinteractive.fbimostwanted.ui.R
import com.psycodeinteractive.fbimostwanted.ui.extension.value
import com.psycodeinteractive.fbimostwanted.ui.feature.splash.mapper.SplashScreenPresentationDestinationToNavigationCallbackMapper
import com.psycodeinteractive.fbimostwanted.ui.screen.OnLifecycle
import com.psycodeinteractive.fbimostwanted.ui.screen.Screen
import com.psycodeinteractive.fbimostwanted.ui.screen.ScreenNavigationContainer
import com.psycodeinteractive.fbimostwanted.ui.screen.observeWithLifecycle
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import kotlinx.coroutines.delay
import me.tatarka.inject.annotations.Inject

typealias SplashScreen = @Composable (
    splashScreenNavigationCallbacks: SplashScreenNavigationCallbacks
) -> Unit

@RootNavGraph(start = true)
@Destination
@Inject
@Composable
fun SplashScreen(
    provideSplashViewModel: () -> SplashViewModel,
    presentationDestinationToNavigationCallbackMapper: SplashScreenPresentationDestinationToNavigationCallbackMapper,
    screenNavigationCallbacks: SplashScreenNavigationCallbacks
) {
    Screen(
        provideViewModel = provideSplashViewModel,
        screenNavigationContainer = ScreenNavigationContainer(
            screenNavigationCallbacks,
            presentationDestinationToNavigationCallbackMapper
        )
    ) { viewModel, _ ->
        OnLifecycle(minActiveState = Lifecycle.State.CREATED) {
            viewModel.onViewCreated()
        }
        Splash()
        HandleEvents(viewModel)
    }
}

@Composable
private fun Splash() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Center)
    ) {
        Text(
            modifier = Modifier.wrapContentSize(),
            text = R.string.app_name.value,
            fontSize = 32.sp,
            color = MaterialTheme.colors.primary
        )
    }
}

@Composable
private fun HandleEvents(
    viewModel: SplashViewModel
) {
    viewModel.eventFlow.observeWithLifecycle { event ->
        when (event) {
            StartSplash -> startSplash(viewModel)
        }
    }
}

private suspend fun startSplash(viewModel: SplashViewModel) {
    delay(splashTimeMilliseconds)
    viewModel.onSplashFinished()
}

private const val splashTimeMilliseconds = 2000L
