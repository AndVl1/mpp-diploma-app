package ru.andvl.mppapp.auth.ktor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthRequest(
    @SerialName("username")
    val login: String,
    @SerialName("password")
    val password: String,
    @SerialName("grant_type")
    val grantType: String = "",
    @SerialName("scope")
    val scope: String = "",
    @SerialName("client_id")
    val clientId: String = "",
    @SerialName("client_secret")
    val clientSecret: String = "client_secret",
)
