package com.karthik.android.techtestkmp.di

import com.karthik.android.techtestkmp.data.network.PlatformConfig
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

expect fun getPlatformEngine(): HttpClientEngine
class KtorClient {

    fun createClient(engine: HttpClientEngine): HttpClient{
        return HttpClient(engine) {

            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    isLenient = true
                })
            }

            defaultRequest {
                url {
                    protocol = URLProtocol.HTTPS
                    host = PlatformConfig.hostName
                }
            }

        }
    }
}