package ru.andvl.mppapp.list.local

import Database
import ru.andvl.mppapp.list.dto.DelaDto
import ru.andvl.mppapp.list.dto.ItemDto

class DelasLocalDataSource(
    private val database: Database
) {
    fun saveDelaList(dela: DelaDto) {
        dela.items
            ?.map { Pair(it.key, it.fio) }
            ?.filter {
                it.first != null && it.second != null
            }
            ?.forEach {
                database.itemsQueries.insert(it.first!!.toLong(), it.second!!)
            }
    }

    fun getLocalDela(): DelaDto {
        val delas = database.itemsQueries.select().executeAsList()
            .map { ItemDto(key = it.key.toInt(), fio = it.fio) }
            .toCollection(ArrayList())
        return DelaDto(items = delas)
    }
}