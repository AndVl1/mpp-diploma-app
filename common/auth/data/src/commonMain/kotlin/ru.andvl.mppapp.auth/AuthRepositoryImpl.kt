package ru.andvl.mppapp.auth

import ru.andvl.mppapp.auth.dto.LoginRequestDto
import ru.andvl.mppapp.auth.dto.WhoAmIDto
import ru.andvl.mppapp.auth.ktor.AuthRequest
import ru.andvl.mppapp.auth.ktor.RemoteAuthDataSource
import ru.andvl.mppapp.auth.repository.AuthRepository
import ru.andvl.mppapp.auth.settings.SettingsAuthDataSource

class AuthRepositoryImpl(
    private val settings: SettingsAuthDataSource,
    private val remote: RemoteAuthDataSource,
) : AuthRepository {
    override suspend fun login(login: String, password: String): LoginRequestDto {
        val resp = remote.performLogin(
            AuthRequest(login = login, password = password)
        )
        settings.saveToken(resp.accessToken)
        return resp
    }

    override suspend fun whoAmI(): WhoAmIDto {
        return remote.checkWhoAmI(settings.getToken())
    }

    override fun isUserLoggedIn(): Boolean {
        return getToken().isNotBlank()
    }

    override fun getToken(): String {
        return settings.getToken()
    }
}