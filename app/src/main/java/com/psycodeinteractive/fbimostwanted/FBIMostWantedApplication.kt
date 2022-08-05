package com.psycodeinteractive.fbimostwanted

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex

class FBIMostWantedApplication : Application() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}
