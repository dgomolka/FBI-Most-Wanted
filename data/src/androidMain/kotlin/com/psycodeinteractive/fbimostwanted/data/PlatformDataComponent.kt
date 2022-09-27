package com.psycodeinteractive.fbimostwanted.data

import android.content.Context
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.local.DatabaseDriverFactory
import com.psycodeinteractive.fbimostwanted.di.Singleton
import me.tatarka.inject.annotations.Provides

interface PlatformDataComponent {

    @Singleton
    @Provides
    fun providesDatabaseDriverFactory(context: Context) = DatabaseDriverFactory(context)
}
