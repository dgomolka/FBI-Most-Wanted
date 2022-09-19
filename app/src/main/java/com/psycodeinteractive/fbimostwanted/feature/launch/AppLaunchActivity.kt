package com.psycodeinteractive.fbimostwanted.feature.launch

import android.annotation.SuppressLint
import android.os.Bundle
import com.psycodeinteractive.fbimostwanted.di.ApplicationComponent
import com.psycodeinteractive.fbimostwanted.di.create
import com.psycodeinteractive.fbimostwanted.ui.feature.launch.LaunchActivity

@SuppressLint("CustomSplashScreen")
class AppLaunchActivity : LaunchActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val applicationComponent = ApplicationComponent::class.create(application)
//        setContent {
//            applicationComponent.splashScreen {
//            }
//        }

        setupScreens(applicationComponent)
    }
}
