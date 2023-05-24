package ru.andvl.mppapp.details.models

sealed interface DetailsAction {
    object BackClicked : DetailsAction
}
