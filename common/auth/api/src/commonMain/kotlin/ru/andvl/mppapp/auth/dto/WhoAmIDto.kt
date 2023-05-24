package ru.andvl.mppapp.auth.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WhoAmIDto(
    @SerialName("full_name")
    val fullName: String? = null,
    @SerialName("roles")
    val roles: List<String>,
    @SerialName("username")
    val username: String,
)
