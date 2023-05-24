package ru.andvl.mppapp.details.api

interface DeloDetailsRepository {
    suspend fun getDelo(id: Int, token: String): DetailsDto?
}
