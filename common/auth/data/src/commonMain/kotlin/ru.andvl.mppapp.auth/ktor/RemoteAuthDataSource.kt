package ru.andvl.mppapp.auth.ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.forms.FormPart
import io.ktor.client.request.forms.formData
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.HttpStatusCode
import io.ktor.http.Parameters
import io.ktor.http.isSuccess
import io.ktor.http.path
import ru.andvl.mppapp.auth.dto.LoginRequestDto
import ru.andvl.mppapp.auth.dto.WhoAmIDto
import ru.andvl.mppapp.auth.exceptions.AuthException

class RemoteAuthDataSource(
    private val httpClient: HttpClient
) {
    suspend fun performLogin(request: AuthRequest): LoginRequestDto {
        return httpClient.post {
            url {
                path("login")
                setBody(FormDataContent(
                    Parameters.build {
                        append("grant_type", request.grantType)
                        append("username", request.login)
                        append("password", request.password)
                        append("scope", request.scope)
                        append("client_id", request.clientId)
                        append("client_secret", request.clientSecret)
                    }
                ))
            }
        }.body()
    }

    suspend fun checkWhoAmI(token: String): WhoAmIDto {
        val req = httpClient.get {
            url {
                path("/whoami")
                bearerAuth(token)
            }
        }
        if (req.status.isSuccess()) {
            return req.body()
        } else if (req.status == HttpStatusCode.Unauthorized) {
            throw AuthException.TokenExpiredException
        } else {
            throw AuthException.OtherException(req.status.description)
        }
    }
}