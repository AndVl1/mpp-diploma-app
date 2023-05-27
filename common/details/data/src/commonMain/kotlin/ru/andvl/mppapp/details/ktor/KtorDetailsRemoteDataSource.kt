package ru.andvl.mppapp.details.ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.get
import io.ktor.http.path
import ru.andvl.mppapp.details.api.DetailsDto

class KtorDetailsRemoteDataSource(
    private val httpClient: HttpClient
) {
    suspend fun getDelo(
        id: Int,
        token: String,
        eng: Boolean = true,
    ): DetailsDto? {
        return try {
            val req = httpClient.get {
                bearerAuth(token)
                url {
                    path("/editor/dela/${id}")
                    parameters.apply {
                        append("eng", eng.toString())
                    }
                }
            }
            req.body()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    suspend fun getPhoto(
        id: Int,
        token: String,
        eng: Boolean = true,
    ) {
        val req = httpClient.get {
            bearerAuth(token)
            url {
                path("/e")
            }
        }
    }
}