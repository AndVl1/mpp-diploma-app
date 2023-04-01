package ru.andvl.mppapp.list.repository

import ru.andvl.mppapp.list.dto.DelaDto
import ru.andvl.mppapp.list.ktor.KtorDelaApiRequest
import ru.andvl.mppapp.list.ktor.KtorDelasRemoteDataSource

class DelaListRepositoryImpl(
    private val remoteDataSource: KtorDelasRemoteDataSource,
) : DelaListRepository {
    override suspend fun getDelas(take: Int, token: String): DelaDto? {
        return remoteDataSource.getDelas(
            KtorDelaApiRequest(),
            token
        )
    }
}
