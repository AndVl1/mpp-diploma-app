package ru.andvl.mppapp.list

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton
import ru.andvl.mppapp.list.ktor.KtorDelasRemoteDataSource
import ru.andvl.mppapp.list.local.DelasLocalDataSource
import ru.andvl.mppapp.list.repository.DelaListRepository
import ru.andvl.mppapp.list.repository.DelaListRepositoryImpl

val delaModule = DI.Module("delaModule") {
    bind<DelaListRepository>() with singleton {
        DelaListRepositoryImpl(instance(), instance())
    }

    bind<KtorDelasRemoteDataSource>() with provider {
        KtorDelasRemoteDataSource(instance(), instance())
    }
    bind<DelasLocalDataSource>() with provider {
        DelasLocalDataSource(instance())
    }
}
