package ru.andvl.mppapp.list.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AllLinkDto(
    @SerialName("comment")
    val comment: String? = null,
    @SerialName("linked_delo_number")
    val linkedDeloNumber: Int? = null,
    @SerialName("relation_type")
    val relationType: String? = null,
    @SerialName("who")
    val who: String? = null
)

@Serializable
data class AllSourceDto(
    @SerialName("comment")
    val comment: String? = null,
    @SerialName("source")
    val source: String? = null,
    @SerialName("source_type")
    val sourceType: String? = null
)

@Serializable
data class AttachedFileDto(
    @SerialName("description")
    val description: String? = null,
    @SerialName("file_id")
    val fileId: String? = null,
    @SerialName("file_type")
    val fileType: String? = null,
    @SerialName("filename")
    val filename: String? = null
)

@Serializable
data class BirthDto(
    @SerialName("dating")
    val dating: String? = null,
    @SerialName("event_ref")
    val eventRef: List<Map<Int, String>?>? = null,
    @SerialName("text")
    val text: String? = null,
    @SerialName("year")
    val year: Int? = null
)

@Serializable
data class CanonizationDto(
    @SerialName("canonization_doc")
    val canonizationDoc: String? = null,
    @SerialName("comment")
    val comment: String? = null,
    @SerialName("feast_days")
    val feastDays: List<FeastDayDto?>? = null,
    @SerialName("initiator")
    val initiator: String? = null,
    @SerialName("saint_title")
    val saintTitle: String? = null,
    @SerialName("when")
    val whenX: String? = null,
    @SerialName("who_canonized")
    val whoCanonized: String? = null
) {
    @Serializable
    data class FeastDayDto(
        @SerialName("day")
        val day: Int? = null,
        @SerialName("description")
        val description: String? = null,
        @SerialName("month")
        val month: Int? = null,
        @SerialName("variable_day")
        val variableDay: String? = null
    )
}

@Serializable
data class DeathDto(
    @SerialName("dating")
    val dating: String? = null,
    @SerialName("event_ref")
    val eventRef: List<Map<Int, String>?>? = null,
    @SerialName("text")
    val text: String? = null,
    @SerialName("year")
    val year: Int? = null
)

@Serializable
data class DocBasisDto(
    @SerialName("additional_info")
    val additionalInfo: String? = null,
    @SerialName("collection")
    val collection: String? = null,
    @SerialName("key")
    val key: Int? = null,
    @SerialName("other_db")
    val otherDb: String? = null,
    @SerialName("version")
    val version: Int? = null
)

@Serializable
class DocDataDto

@Serializable
data class EventDto(
    @SerialName("begin")
    val begin: BeginDto? = null,
    @SerialName("comment")
    val comment: String? = null,
    @SerialName("dating")
    val dating: String? = null,
    @SerialName("end")
    val end: EndDto? = null,
    @SerialName("event_type")
    val eventType: String? = null,
    @SerialName("links")
    val links: List<LinkDto?>? = null,
    @SerialName("places")
    val places: List<PlaceDto?>? = null,
    @SerialName("search_dates")
    val searchDates: List<SearchDateDto?>? = null,
    @SerialName("sources")
    val sources: List<SourceDto?>? = null,
    @SerialName("text")
    val text: String? = null
) {
    @Serializable
    data class BeginDto(
        @SerialName("additional_info")
        val additionalInfo: String? = null,
        @SerialName("day")
        val day: Int? = null,
        @SerialName("month")
        val month: Int? = null,
        @SerialName("year")
        val year: Int? = null
    )

    @Serializable
    data class EndDto(
        @SerialName("additional_info")
        val additionalInfo: String? = null,
        @SerialName("day")
        val day: Int? = null,
        @SerialName("month")
        val month: Int? = null,
        @SerialName("year")
        val year: Int? = null
    )

    @Serializable
    data class LinkDto(
        @SerialName("comment")
        val comment: String? = null,
        @SerialName("linked_delo_number")
        val linkedDeloNumber: Int? = null,
        @SerialName("relation_type")
        val relationType: String? = null,
        @SerialName("who")
        val who: String? = null
    )

    @Serializable
    data class PlaceDto(
        @SerialName("address")
        val address: String? = null,
        @SerialName("comment")
        val comment: String? = null,
        @SerialName("coordinates")
        val coordinates: CoordinatesDto? = null,
        @SerialName("place_type")
        val placeType: String? = null
    ) {
        @Serializable
        data class CoordinatesDto(
            @SerialName("coordinates")
            val coordinates: List<Int?>? = null,
            @SerialName("type")
            val type: String? = null
        )
    }

    @Serializable
    data class SearchDateDto(
        @SerialName("begin_max")
        val beginMax: String? = null,
        @SerialName("begin_min")
        val beginMin: String? = null,
        @SerialName("days_count")
        val daysCount: Int? = null,
        @SerialName("end_max")
        val endMax: String? = null,
        @SerialName("end_min")
        val endMin: String? = null
    )

    @Serializable
    data class SourceDto(
        @SerialName("all_sources_ref")
        val allSourcesRef: Map<Int, String>? = null,
        @SerialName("comment")
        val comment: String? = null,
        @SerialName("source")
        val source: String? = null,
        @SerialName("source_type")
        val sourceType: String? = null
    )
}

@Serializable
data class FioPartDto(
    @SerialName("part")
    val part: String? = null,
    @SerialName("type")
    val type: String? = null,
    @SerialName("value")
    val value: String? = null
)

@Serializable
data class OtherLinkDto(
    @SerialName("comment")
    val comment: String? = null,
    @SerialName("linked_delo_number")
    val linkedDeloNumber: Int? = null,
    @SerialName("relation_type")
    val relationType: String? = null,
    @SerialName("who")
    val who: String? = null
)

@Serializable
data class OtherSourceDto(
    @SerialName("comment")
    val comment: String? = null,
    @SerialName("source")
    val source: String? = null,
    @SerialName("source_type")
    val sourceType: String? = null
)

@Serializable
data class PhotoDto(
    @SerialName("caption")
    val caption: String? = null,
    @SerialName("filename")
    val filename: String? = null,
    @SerialName("original_file_id")
    val originalFileId: String? = null,
    @SerialName("resized_file_id")
    val resizedFileId: String? = null
)