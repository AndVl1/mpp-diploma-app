package ru.andvl.mppapp.list.ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.get
import io.ktor.client.request.setBody
import io.ktor.http.path
import ru.andvl.mppapp.list.dto.DelaDto

class KtorDelasRemoteDataSource(
    private val httpClient: HttpClient
) {
    suspend fun getDelas(
        params: KtorDelaApiRequest,
        token: String
    ): DelaDto? {
        return try {
            val req = httpClient.get {
                bearerAuth(token)
                url {
                    path("/editor/dela")
                    parameters.apply {
                        append("fio_filter", params.fioFilter)
                        append("filter", params.filter)
                        append("skip", params.skip.toString())
                        append("take", params.take.toString())
                        append("sort", params.sort)
                        append("calc_total_count", params.calcTotalCount.toString())
                        append("eng", params.eng.toString())
                    }
                }
            }
            req.body()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}