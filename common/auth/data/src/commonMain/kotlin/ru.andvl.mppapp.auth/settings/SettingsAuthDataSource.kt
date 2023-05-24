package ru.andvl.mppapp.auth.settings

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get

class SettingsAuthDataSource(
    private val settings: Settings
) {
    fun saveToken(token: String) {
        settings.putString(TOKEN_KEY, token)
    }

    fun getToken(): String {
        return settings[TOKEN_KEY, ""]
    }

    companion object {
        private const val TOKEN_KEY = "auth_token"
    }
}
