package ru.andvl.mppapp.details.models

sealed interface DetailsEvent {
    object BackPressed : DetailsEvent
}