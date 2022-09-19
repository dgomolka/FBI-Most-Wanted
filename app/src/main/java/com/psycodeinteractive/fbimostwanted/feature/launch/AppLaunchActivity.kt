package com.psycodeinteractive.fbimostwanted.feature.launch

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import com.psycodeinteractive.fbimostwanted.data.PlatformDataComponent
import com.psycodeinteractive.fbimostwanted.data.create
import com.psycodeinteractive.fbimostwanted.di.DataComponent
import com.psycodeinteractive.fbimostwanted.di.DomainComponent
import com.psycodeinteractive.fbimostwanted.di.LoggerComponent
import com.psycodeinteractive.fbimostwanted.di.PresentationComponent
import com.psycodeinteractive.fbimostwanted.di.ScreenComponent
import com.psycodeinteractive.fbimostwanted.di.UiComponent
import com.psycodeinteractive.fbimostwanted.di.create
import com.psycodeinteractive.fbimostwanted.ui.feature.launch.LaunchActivity

const val d = ""

@SuppressLint("CustomSplashScreen")
class AppLaunchActivity : LaunchActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val screenComponent = run {
            val platformDataComponent = PlatformDataComponent::class.create(application)
            val dataComponent = DataComponent::class.create(platformDataComponent)
            val domainComponent = DomainComponent::class.create(dataComponent)
            val loggerComponent = LoggerComponent::class.create()
            val presentationComponent =
                PresentationComponent::class.create(domainComponent, loggerComponent)
            ScreenComponent::class.create(
                presentationComponent,
                UiComponent::class.create()
            )
        }

        setupScreens(
            screenComponent.splashScreen,
            screenComponent.mostWantedListScreen,
            screenComponent.mostWantedPersonScreen
        )
    }
}
