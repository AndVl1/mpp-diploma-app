package ru.andvl.mppapp.list.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DelaDto(
    @SerialName("has_next")
    val hasNext: Boolean? = null,
    @SerialName("items")
    val items: List<ItemDto>? = null,
    @SerialName("items_count")
    val itemsCount: Int? = null,
    @SerialName("skip")
    val skip: Int? = null,
    @SerialName("success")
    val success: Boolean? = null,
    @SerialName("take")
    val take: Int? = null,
    @SerialName("total_docs_count")
    val totalDocsCount: Int? = null
)
