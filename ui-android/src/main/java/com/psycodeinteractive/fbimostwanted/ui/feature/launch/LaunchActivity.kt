package com.psycodeinteractive.fbimostwanted.ui.feature.launch

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle.Event.ON_START
import androidx.lifecycle.Lifecycle.Event.ON_STOP
import androidx.lifecycle.LifecycleEventObserver
import com.psycodeinteractive.fbimostwanted.di.ScreenComponent
import com.psycodeinteractive.fbimostwanted.presentation.feature.launch.MainViewModel
import com.psycodeinteractive.fbimostwanted.ui.Theme
import com.psycodeinteractive.fbimostwanted.ui.feature.NavGraphs
import com.psycodeinteractive.fbimostwanted.ui.feature.destinations.MostWantedListScreenDestination
import com.psycodeinteractive.fbimostwanted.ui.feature.destinations.MostWantedPersonScreenDestination
import com.psycodeinteractive.fbimostwanted.ui.feature.destinations.SplashScreenDestination
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedlist.MostWantedListScreenNavigationCallbacks
import com.psycodeinteractive.fbimostwanted.ui.feature.splash.SplashScreenNavigationCallbacks
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.manualcomposablecalls.composable
import me.tatarka.inject.annotations.Inject

abstract class LaunchActivity : ComponentActivity() {

    fun setupScreens(
        screenComponent: ScreenComponent
    ) {
        setContent {
            Theme {
                screenComponent.appEntryPoint(screenComponent)
            }
        }
    }
}

typealias AppEntryPoint = @Composable (ScreenComponent) -> Unit

@Inject
@Composable
fun AppEntryPoint(
    providesMainViewModel: () -> MainViewModel,
    screenComponent: ScreenComponent
) {
    val viewModel = providesMainViewModel()
    LocalLifecycleOwner.current.run {
        DisposableEffect(this) {
            val observer = viewModel.lifecycleEventObserver
            with(lifecycle) {
                addObserver(observer)
                onDispose {
                    removeObserver(observer)
                }
            }
        }
    }

    DestinationsNavHost(
        navGraph = NavGraphs.root
    ) {
        composable(SplashScreenDestination) {
            val screenNavigationCallbacks = SplashScreenNavigationCallbacks(
                goToMostWantedList = {
                    destinationsNavigator.navigate(MostWantedListScreenDestination)
                }
            )
            screenComponent.splashScreen(screenNavigationCallbacks)
        }
        composable(MostWantedListScreenDestination) {
            val screenNavigationCallbacks = MostWantedListScreenNavigationCallbacks(
                goToPersonDetails = { personId ->
                    destinationsNavigator.navigate(MostWantedPersonScreenDestination(personId = personId))
                }
            )
            screenComponent.mostWantedListScreen(screenNavigationCallbacks)
        }
        composable(MostWantedPersonScreenDestination) {
            screenComponent.mostWantedPersonScreen(
                personId = navArgs.personId
            )
        }
    }
}

private val MainViewModel.lifecycleEventObserver
    get() = LifecycleEventObserver { _, event ->
        if (event == ON_START) {
            onStart()
        } else if (event == ON_STOP) {
            onStop()
        }
    }
