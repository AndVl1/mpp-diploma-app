package ru.andvl.mppapp.auth.models

sealed interface LoginEvent {
    object LoginClicked : LoginEvent
    data class LoginChanged(
        val value: String
    ) : LoginEvent
    data class PasswordChanged(
        val value: String
    ) : LoginEvent
}
