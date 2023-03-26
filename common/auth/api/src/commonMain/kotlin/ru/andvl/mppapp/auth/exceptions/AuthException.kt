package ru.andvl.mppapp.auth.exceptions

sealed class AuthException : Exception() {
    object TokenExpiredException : AuthException()
    data class OtherException(val reason: String) : AuthException()
}
