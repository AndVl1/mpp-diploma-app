package ru.andvl.mppapp.auth.models

data class LoginViewState(
    val login: String,
    val password: String,
    val isSending: Boolean = false,
    val passwordHidden: Boolean = true,
)
