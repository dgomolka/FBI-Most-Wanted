package com.psycodeinteractive.fbimostwanted.data.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel.ALL
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.http.URLProtocol.Companion.HTTPS
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

expect val httpClientEngine: HttpClientEngine

interface ApiConfig {
    val baseUrl: String
}

class NetworkClient(
    private val apiConfig: ApiConfig
) {
    val client: HttpClient = HttpClient(httpClientEngine) {
        defaultRequest {
            host = apiConfig.baseUrl
            port = 0
            url {
                protocol = HTTPS
            }
        }

        install(Logging) {
            logger = Logger.DEFAULT
            level = ALL
        }

        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                }
            )
        }
    }

    suspend inline fun <reified Model> get(
        path: String
    ) = client.get {
        url {
            path(path)
        }
    }.body<Model>()
}
