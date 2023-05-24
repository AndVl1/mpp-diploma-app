package ru.andvl.mppapp.details

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton
import ru.andvl.mppapp.details.api.DeloDetailsRepository
import ru.andvl.mppapp.details.ktor.KtorDetailsRemoteDataSource
import ru.andvl.mppapp.details.repository.DetailsRepositoryImpl

val detailsModule = DI.Module("detailsModule") {
    bind<DeloDetailsRepository>() with singleton {
        DetailsRepositoryImpl(instance())
    }
    bind<KtorDetailsRemoteDataSource>() with provider {
        KtorDetailsRemoteDataSource(instance())
    }
}