package database

import PlatformConfiguration
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver

actual class DbDriverFactory actual constructor(val platformConfiguration: PlatformConfiguration) {
    actual fun createDriver(
        name: String
    ): SqlDriver = AndroidSqliteDriver(Database.Schema, platformConfiguration.androidContext, name)
}