package ru.andvl.mppapp.auth.repository

import ru.andvl.mppapp.auth.dto.LoginRequestDto
import ru.andvl.mppapp.auth.dto.WhoAmIDto

interface AuthRepository {
    suspend fun login(login: String, password: String): LoginRequestDto
    suspend fun whoAmI(): WhoAmIDto
    fun isUserLoggedIn(): Boolean
}
