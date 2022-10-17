@file:OptIn(ExperimentalCoroutinesApi::class)

package com.psycodeinteractive.fbimostwanted.domain.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.setMain

private val testScope = TestScope()
private val testDispatcher = StandardTestDispatcher(testScope.testScheduler)
val testCoroutineScope
    get() = testScope.apply {
        if (Dispatchers.Main != testDispatcher) {
            Dispatchers.setMain(testDispatcher)
        }
    }
