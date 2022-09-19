package com.psycodeinteractive.fbimostwanted.di

import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedlist.MostWantedListScreen
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.MostWantedPersonScreen
import com.psycodeinteractive.fbimostwanted.ui.feature.splash.SplashScreen
import me.tatarka.inject.annotations.Component

@Component
abstract class ScreenComponent(
    @Component val presentationComponent: PresentationComponent,
    @Component val uiComponent: UiComponent
) : ScreenGraphComponent {
    abstract override val splashScreen: SplashScreen
    abstract override val mostWantedListScreen: MostWantedListScreen
    abstract override val mostWantedPersonScreen: MostWantedPersonScreen
}
