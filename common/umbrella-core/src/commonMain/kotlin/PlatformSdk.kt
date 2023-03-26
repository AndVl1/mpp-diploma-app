import di.Inject
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.direct
import org.kodein.di.singleton
import ru.andvl.mppapp.auth.authModule
import ru.andvl.mppapp.list.delaModule

object PlatformSdk {
    fun init(
        platformConfiguration: PlatformConfiguration
    ) {
        val umbrellaModule = DI.Module("umbrella") {
            bind<PlatformConfiguration>() with singleton { platformConfiguration }
        }

        Inject.createDeps(
            DI {
                importAll(
                    umbrellaModule,
                    coreModule,
                    delaModule,
                    authModule,
                )
            }.direct
        )
    }
}