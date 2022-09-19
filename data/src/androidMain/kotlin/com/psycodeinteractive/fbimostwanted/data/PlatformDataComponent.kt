package com.psycodeinteractive.fbimostwanted.data

import android.content.Context
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.local.DatabaseDriverFactory
import me.tatarka.inject.annotations.Provides

interface PlatformDataComponent {
    @Provides
    fun providesDatabaseDriverFactory(context: Context) = DatabaseDriverFactory(context)
}
