package com.grishchenkova.app.httpClient

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.okhttp.OkHttp
import java.util.concurrent.TimeUnit

actual class HttpClient {
    actual fun httpClient(config: HttpClientConfig<*>.() -> Unit) = HttpClient(OkHttp) {
        config(this)
        engine {
            config {
                retryOnConnectionFailure(false)
                connectTimeout(39, TimeUnit.SECONDS)
            }
        }
    }
}