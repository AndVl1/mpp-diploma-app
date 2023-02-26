package database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import PlatformConfiguration

actual class DbDriverFactory actual constructor(platformConfiguration: PlatformConfiguration){
    actual fun createDriver(name: String): SqlDriver = NativeSqliteDriver(Database.Schema, name)
}
