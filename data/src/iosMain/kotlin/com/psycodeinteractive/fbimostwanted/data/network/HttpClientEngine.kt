package com.psycodeinteractive.fbimostwanted.data.network

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin

actual val httpClientEngine: HttpClientEngine
    get() = Darwin.create {
        configureRequest {
        }
    }
