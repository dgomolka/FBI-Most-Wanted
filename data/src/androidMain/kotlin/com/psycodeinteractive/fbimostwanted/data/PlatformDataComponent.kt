package com.psycodeinteractive.fbimostwanted.data

import android.app.Application
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.local.DatabaseDriverFactory
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@Component
abstract class PlatformDataComponent {
    @Provides
    fun providesDatabaseDriverFactory(application: Application) = DatabaseDriverFactory(application)
}

val platformDataComponent = PlatformDataComponent::class.create()
