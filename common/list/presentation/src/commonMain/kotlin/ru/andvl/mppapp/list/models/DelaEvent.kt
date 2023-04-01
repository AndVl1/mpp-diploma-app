package ru.andvl.mppapp.list.models

sealed interface DelaEvent {
    object Refresh : DelaEvent
    object DeloClick : DelaEvent
}
