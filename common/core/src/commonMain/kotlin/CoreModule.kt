import database.databaseModule
import json.serializationModule
import ktor.ktorModule
import org.kodein.di.DI
import settings.settingsModule

val coreModule = DI.Module("coreModule") {
    importAll(ktorModule, serializationModule, databaseModule, settingsModule)
}
