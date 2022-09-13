package com.psycodeinteractive.fbimostwanted.di

import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedlist.MostWantedListScreen
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.MostWantedPersonScreen
import com.psycodeinteractive.fbimostwanted.ui.feature.splash.SplashScreen
import me.tatarka.inject.annotations.Component

@Component
abstract class ScreenComponent {
    abstract val splashScreen: SplashScreen
    abstract val mostWantedListScreen: MostWantedListScreen
    abstract val mostWantedPersonScreen: MostWantedPersonScreen
}
