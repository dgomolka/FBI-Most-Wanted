package com.psycodeinteractive.fbimostwanted.di

import android.content.Context
import com.psycodeinteractive.fbimostwanted.data.PlatformDataComponent
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedlist.MostWantedListScreen
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.MostWantedPersonScreen
import com.psycodeinteractive.fbimostwanted.ui.feature.splash.SplashScreen
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@Component
abstract class ApplicationComponent(
    @get:Provides val context: Context
) : UiComponent, ScreenComponent, PresentationComponent, DomainComponent, DataComponent, PlatformDataComponent {
    abstract override val splashScreen: SplashScreen
    abstract override val mostWantedListScreen: MostWantedListScreen
    abstract override val mostWantedPersonScreen: MostWantedPersonScreen
}
