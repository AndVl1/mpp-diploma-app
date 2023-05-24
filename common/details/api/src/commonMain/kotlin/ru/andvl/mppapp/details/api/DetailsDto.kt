package ru.andvl.mppapp.details.api


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DetailsDto(
    @SerialName("additional_text")
    val additionalText: String? = null,
    @SerialName("attached_files")
    val attachedFiles: List<AttachedFileDto?>? = null,
    @SerialName("canonization")
    val canonization: CanonizationDto? = null,
    @SerialName("doc_author")
    val docAuthor: String? = null,
    @SerialName("doc_basis")
    val docBasis: DocBasisDto? = null,
    @SerialName("doc_created")
    val docCreated: String? = null,
    @SerialName("doc_last_editor")
    val docLastEditor: String? = null,
    @SerialName("doc_updated")
    val docUpdated: String? = null,
    @SerialName("doc_version")
    val docVersion: Int? = null,
    @SerialName("events")
    val events: List<EventDto?>? = null,
    @SerialName("exclude")
    val exclude: String? = null,
    @SerialName("fio")
    val fio: String? = null,
    @SerialName("key")
    val key: Int? = null,
    @SerialName("other_links")
    val otherLinks: List<OtherLinkDto?>? = null,
    @SerialName("other_sources")
    val otherSources: List<OtherSourceDto?>? = null,
    @SerialName("post")
    val post: String? = null
) {
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
    data class EventDto(
        @SerialName("comment")
        val comment: String? = null,
        @SerialName("dating")
        val dating: String? = null,
        @SerialName("event_type")
        val eventType: String? = null,
        @SerialName("links")
        val links: List<LinkDto?>? = null,
        @SerialName("places")
        val places: List<PlaceDto?>? = null,
        @SerialName("sources")
        val sources: List<SourceDto?>? = null,
        @SerialName("text")
        val text: String? = null
    ) {
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
        data class SourceDto(
            @SerialName("comment")
            val comment: String? = null,
            @SerialName("source")
            val source: String? = null,
            @SerialName("source_type")
            val sourceType: String? = null
        )
    }

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
}