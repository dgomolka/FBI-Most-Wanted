package com.psycodeinteractive.fbimostwanted

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex

class FBIMostWantedApplication : Application() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
//        ApplicationComponent::class.create(screenComponent, DataComponent::class.create(), PlatformDataComponent::class.create())
    }
}
