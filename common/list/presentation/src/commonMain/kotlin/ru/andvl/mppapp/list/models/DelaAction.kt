package ru.andvl.mppapp.list.models

sealed interface DelaAction {
    data class OpenDetails(val id: Int) : DelaAction
}
