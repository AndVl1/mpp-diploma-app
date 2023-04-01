package ru.andvl.mppapp.auth.repository

import ru.andvl.mppapp.auth.dto.LoginRequestDto
import ru.andvl.mppapp.auth.dto.WhoAmIDto

interface AuthRepository {
    suspend fun login(login: String = "mobile-app", password: String = "m0b1le0323"): LoginRequestDto
    @Throws(Exception::class)
    suspend fun whoAmI(): WhoAmIDto?
    fun isUserLoggedIn(): Boolean
    fun getToken(): String
}
