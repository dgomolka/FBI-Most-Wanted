package com.psycodeinteractive.fbimostwanted.di

import com.psycodeinteractive.fbimostwanted.domain.base.Logger
import com.psycodeinteractive.fbimostwanted.domain.base.usecase.CoroutineContextProvider
import com.psycodeinteractive.fbimostwanted.domain.base.usecase.PlatformCoroutineContextProvider
import com.psycodeinteractive.fbimostwanted.domain.execution.UseCaseExecutor
import com.psycodeinteractive.fbimostwanted.presentation.execution.UseCaseExecutorProvider

object DomainModule {

    fun provideCoroutineContextProvider(): CoroutineContextProvider =
        PlatformCoroutineContextProvider()

    fun providesUseCaseExecutorProvider(logger: Logger): UseCaseExecutorProvider =
        { coroutineScope -> UseCaseExecutor(coroutineScope, logger) }
}
