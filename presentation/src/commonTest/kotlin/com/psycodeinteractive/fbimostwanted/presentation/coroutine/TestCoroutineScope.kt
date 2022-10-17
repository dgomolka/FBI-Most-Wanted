package com.psycodeinteractive.fbimostwanted.presentation.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.setMain

val testCoroutineScope
    get() = TestScope().apply {
        val testDispatcher = StandardTestDispatcher(testScheduler)
        if (Dispatchers.Main != testDispatcher) {
            Dispatchers.setMain(testDispatcher)
        }
    }
