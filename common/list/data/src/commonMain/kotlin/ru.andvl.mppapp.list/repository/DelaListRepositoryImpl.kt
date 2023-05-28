package ru.andvl.mppapp.list.repository

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import ru.andvl.mppapp.list.dto.DelaDto
import ru.andvl.mppapp.list.ktor.KtorDelaApiRequest
import ru.andvl.mppapp.list.ktor.KtorDelasRemoteDataSource
import ru.andvl.mppapp.list.local.DelasLocalDataSource

class DelaListRepositoryImpl(
    private val remoteDataSource: KtorDelasRemoteDataSource,
    private val localDataSource: DelasLocalDataSource,
) : DelaListRepository {
    override suspend fun getDelas(take: Int, token: String): DelaDto? {
        val now = Clock.System.now()
        val datetime = now.toLocalDateTime(TimeZone.currentSystemDefault())
        println("${datetime.monthNumber}, ${datetime.dayOfMonth}")
        val filter = KtorDelaApiRequest.Filter(datetime.monthNumber.toString(), datetime.dayOfMonth.toString())
        return remoteDataSource.getDelas(
            KtorDelaApiRequest(filter = filter),
            token
        )?.also {
            localDataSource.saveDelaList(it)
        } ?: localDataSource.getLocalDela()
    }
}
