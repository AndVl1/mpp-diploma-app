package ru.andvl.mppapp.auth.models

sealed interface LoginAction {
    object OpenMainFlow : LoginAction
}