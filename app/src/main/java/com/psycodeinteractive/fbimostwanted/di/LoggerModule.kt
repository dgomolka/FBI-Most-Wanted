package com.psycodeinteractive.fbimostwanted.di

import com.psycodeinteractive.fbimostwanted.domain.logger.PlatformLogger

class LoggerModule {
    fun providesLogger() = PlatformLogger()
}
