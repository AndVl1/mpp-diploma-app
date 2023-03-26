package ru.andvl.mppapp.list.repository

import ru.andvl.mppapp.list.dto.DelaDto

interface DelaListRepository {
    suspend fun getDelas(take: Int = 20): DelaDto
}