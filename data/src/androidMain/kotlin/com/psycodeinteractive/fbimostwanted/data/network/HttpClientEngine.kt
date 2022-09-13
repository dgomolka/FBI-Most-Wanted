package com.psycodeinteractive.fbimostwanted.data.network

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp

actual val httpClientEngine: HttpClientEngine
    get() = OkHttp.create {
        config {
            followRedirects(true)
        }
    }
