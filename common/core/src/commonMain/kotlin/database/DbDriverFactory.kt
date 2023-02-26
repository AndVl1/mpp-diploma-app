package database

import PlatformConfiguration
import app.cash.sqldelight.db.SqlDriver

expect class DbDriverFactory(platformConfiguration: PlatformConfiguration) {
    fun createDriver(name: String): SqlDriver
}
