package com.psycodeinteractive.fbimostwanted.ui.feature.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.psycodeinteractive.fbimostwanted.presentation.feature.splash.SplashEvent.SplashFinished
import com.psycodeinteractive.fbimostwanted.presentation.feature.splash.SplashEvent.StartSplash
import com.psycodeinteractive.fbimostwanted.presentation.feature.splash.SplashViewModel
import com.psycodeinteractive.fbimostwanted.ui.R
import com.psycodeinteractive.fbimostwanted.ui.Screen
import com.psycodeinteractive.fbimostwanted.ui.observeWithLifecycle
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import kotlinx.coroutines.delay
import me.tatarka.inject.annotations.Inject

typealias SplashScreen = @Composable (
    onSplashFinished: () -> Unit
) -> Unit

@RootNavGraph(start = true)
@Destination
@Inject
@Composable
fun SplashScreen(
    provideSplashViewModel: () -> SplashViewModel,
    onSplashFinished: () -> Unit
) {
    Screen(provideSplashViewModel) { viewModel, _ ->
        Splash()
        HandleEvents(viewModel, onSplashFinished)
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
            text = stringResource(id = R.string.app_name),
            fontSize = 32.sp,
            color = MaterialTheme.colors.primary
        )
    }
}

@Composable
private fun HandleEvents(
    viewModel: SplashViewModel,
    onSplashFinished: () -> Unit
) {
    viewModel.eventFlow.observeWithLifecycle { event ->
        when (event) {
            StartSplash -> startSplash(viewModel)
            SplashFinished -> onSplashFinished()
        }
    }
}

private suspend fun startSplash(viewModel: SplashViewModel) {
    delay(splashTimeMilliseconds)
    viewModel.onSplashFinished()
}

private const val splashTimeMilliseconds = 2000L
