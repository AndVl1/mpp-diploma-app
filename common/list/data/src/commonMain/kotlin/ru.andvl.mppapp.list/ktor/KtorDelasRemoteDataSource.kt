package ru.andvl.mppapp.list.ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.setBody
import io.ktor.http.path
import ru.andvl.mppapp.list.dto.DelaDto

class KtorDelasRemoteDataSource(
    private val httpClient: HttpClient
) {
    suspend fun getDelas(params: KtorDelaApiRequest): DelaDto {
        return httpClient.get {
            url {
                path("/editor/dela")
                setBody(params)
            }
        }.body()
    }
}