package ru.andvl.mppapp.list.models

sealed interface DelaEvent {
    object Refresh : DelaEvent
    object DeloOpen : DelaEvent
    data class DeloClick(val id: Long) : DelaEvent
}
