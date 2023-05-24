package ru.andvl.mppapp.details.repository

import ru.andvl.mppapp.details.api.DeloDetailsRepository
import ru.andvl.mppapp.details.api.DetailsDto
import ru.andvl.mppapp.details.ktor.KtorDetailsRemoteDataSource

class DetailsRepositoryImpl(
    private val dataSource: KtorDetailsRemoteDataSource,
) : DeloDetailsRepository {
    override suspend fun getDelo(id: Int, token: String): DetailsDto? {
        return dataSource.getDelo(id, token)
    }
}