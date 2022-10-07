package com.psycodeinteractive.fbimostwanted.di

import com.psycodeinteractive.fbimostwanted.ui.feature.launch.AppEntryPoint
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedlist.MostWantedListScreen
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.MostWantedPersonScreen
import com.psycodeinteractive.fbimostwanted.ui.feature.splash.SplashScreen

interface ScreenComponent {
    val appEntryPoint: AppEntryPoint
    val splashScreen: SplashScreen
    val mostWantedListScreen: MostWantedListScreen
    val mostWantedPersonScreen: MostWantedPersonScreen
}
