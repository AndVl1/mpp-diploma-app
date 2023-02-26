package database

import Database
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

internal val databaseModule = DI.Module("databaseModule") {
    bind<DbDriverFactory>() with singleton {
        DbDriverFactory(instance())
    }
    bind<Database>() with singleton {
        val driverFactory: DbDriverFactory = instance()
        val driver = driverFactory
            .createDriver("cache.db")
        Database(driver)
    }
}