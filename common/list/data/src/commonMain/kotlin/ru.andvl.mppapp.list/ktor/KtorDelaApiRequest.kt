package ru.andvl.mppapp.list.ktor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KtorDelaApiRequest(
    @SerialName("fio_filter")
    val fioFilter: Boolean = true,
    @SerialName("filter")
    val filter: String = "",
    @SerialName("skip")
    val skip: Int = 0,
    @SerialName("take")
    val take: Int = 20,
    @SerialName("sort")
    val sort: String = "",
    @SerialName("calc_total_count")
    val calcTotalCount: Boolean = true,
    @SerialName("end")
    val eng: Boolean = true,
)
