package ru.andvl.mppapp.auth

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton
import ru.andvl.mppapp.auth.ktor.RemoteAuthDataSource
import ru.andvl.mppapp.auth.repository.AuthRepository
import ru.andvl.mppapp.auth.settings.SettingsAuthDataSource

val authModule = DI.Module("authModule") {
    bind<AuthRepository>() with singleton {
        AuthRepositoryImpl(instance(), instance())
    }

    bind<SettingsAuthDataSource>() with provider {
        SettingsAuthDataSource(instance())
    }

    bind<RemoteAuthDataSource>() with provider {
        RemoteAuthDataSource(instance())
    }
}
