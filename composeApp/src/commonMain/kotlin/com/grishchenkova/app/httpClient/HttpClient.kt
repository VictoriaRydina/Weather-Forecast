package com.grishchenkova.app.httpClient

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig

expect class HttpClient {
    fun httpClient(config: HttpClientConfig<*>.() -> Unit): HttpClient
}