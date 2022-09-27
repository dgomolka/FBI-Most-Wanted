package com.psycodeinteractive.fbimostwanted.di

import com.psycodeinteractive.fbimostwanted.domain.logger.Logger
import com.psycodeinteractive.fbimostwanted.domain.logger.PlatformLogger
import me.tatarka.inject.annotations.Provides

interface LoggerComponent {
    @Singleton
    @Provides
    fun providesLogger(): Logger = PlatformLogger()
}
