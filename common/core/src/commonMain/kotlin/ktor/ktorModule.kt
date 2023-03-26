package ktor

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

internal val ktorModule = DI.Module("ktorModule") {
    bind<HttpClient>() with singleton {
        HttpClient(HttpEngineFactory().createEngine()) {
            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }

            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                })
            }

            install(HttpTimeout) {
                connectTimeoutMillis = 15000
                requestTimeoutMillis = 30000
            }

            install(Auth) {
                bearer {
                    loadTokens {
                        BearerTokens("", "")
                    }
                }
            }

            defaultRequest {
                url("http://api.nmbook.ru/")
                header("accept", "application/json; charset=UTF-8")
                header("Content-Type", "application/x-www-form-urlencoded")
            }
        }
    }
}
