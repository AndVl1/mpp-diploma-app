package ru.andvl.mppapp.list.ktor

import kotlinx.datetime.Clock
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KtorDelaApiRequest(
    @SerialName("fio_filter")
    val fioFilter: String = "",
    @SerialName("filter")
    val filter: String = "",
    @SerialName("skip")
    val skip: Int = 0,
    @SerialName("take")
    val take: Int = 50,
    @SerialName("sort")
    val sort: String = "",
    @SerialName("calc_total_count")
    val calcTotalCount: Boolean = true,
    @SerialName("eng")
    val eng: Boolean = true,
) {
    @Serializable
    data class Filter(
        @SerialName("death.month")
        val deathMonth: String,
        @SerialName("death.day")
        val deathDay: String,
    )
}
