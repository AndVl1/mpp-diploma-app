package ru.andvl.mppapp.list.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemDto(
    @SerialName("action")
    val action: String? = null,
    @SerialName("additional_text")
    val additionalText: String? = null,
    @SerialName("all_links")
    val allLinks: List<AllLinkDto?>? = null,
    @SerialName("all_sources")
    val allSources: List<AllSourceDto?>? = null,
    @SerialName("attached_files")
    val attachedFiles: List<AttachedFileDto?>? = null,
    @SerialName("author")
    val author: String? = null,
    @SerialName("birth")
    val birth: BirthDto? = null,
    @SerialName("birth_year")
    val birthYear: Int? = null,
    @SerialName("canonization")
    val canonization: CanonizationDto? = null,
    @SerialName("coll")
    val coll: String? = null,
    @SerialName("created")
    val created: String? = null,
    @SerialName("death")
    val death: DeathDto? = null,
    @SerialName("death_year")
    val deathYear: Int? = null,
    @SerialName("doc_author")
    val docAuthor: String? = null,
    @SerialName("doc_basis")
    val docBasis: DocBasisDto? = null,
    @SerialName("doc_created")
    val docCreated: String? = null,
    @SerialName("doc_data")
    val docData: DocDataDto? = null,
    @SerialName("doc_key")
    val docKey: Int? = null,
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
    @SerialName("fio_parts")
    val fioParts: List<FioPartDto?>? = null,
    @SerialName("gender")
    val gender: String? = null,
    @SerialName("id_version")
    val idVersion: Int? = null,
    @SerialName("key")
    val key: Int? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("other_links")
    val otherLinks: List<OtherLinkDto?>? = null,
    @SerialName("other_sources")
    val otherSources: List<OtherSourceDto?>? = null,
    @SerialName("patronymic")
    val patronymic: String? = null,
    @SerialName("photos")
    val photos: List<PhotoDto?>? = null,
    @SerialName("post")
    val post: String? = null,
    @SerialName("saint_title")
    val saintTitle: String? = null,
    @SerialName("snippet")
    val snippet: String? = null,
    @SerialName("surname")
    val surname: String? = null
)