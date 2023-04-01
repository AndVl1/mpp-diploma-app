package ru.andvl.mppapp.list

import com.adeo.kviewmodel.BaseSharedViewModel
import com.adeo.kviewmodel.KViewModel
import di.Inject
import kotlinx.coroutines.launch
import ru.andvl.mppapp.auth.repository.AuthRepository
import ru.andvl.mppapp.list.models.DelaAction
import ru.andvl.mppapp.list.models.DelaEvent
import ru.andvl.mppapp.list.models.DelaViewState
import ru.andvl.mppapp.list.repository.DelaListRepository

class DelaListViewModel : BaseSharedViewModel<DelaViewState, DelaAction, DelaEvent>(
    initialState = DelaViewState()
) {
    private val authRepository: AuthRepository = Inject.instance()
    private val delaRepository: DelaListRepository = Inject.instance()

    init {
        viewModelScope.launch {
            viewState = viewState.copy(isLoading = true)
            checkLogin()
            getDela()
        }
    }

    override fun obtainEvent(viewEvent: DelaEvent) {
        when (viewEvent) {
            DelaEvent.Refresh -> {
                viewState = viewState.copy(isLoading = true, dela = null, isError = false)
                viewModelScope.launch {
                    getDela()
                }
            }
            DelaEvent.DeloClick -> {}
        }
    }

    private suspend fun checkLogin() {
        if (authRepository.isUserLoggedIn()) {
            try {
                authRepository.whoAmI()
            } catch (e: Exception) {
                authRepository.login()
            }
        } else {
            authRepository.login()
        }
    }

    private suspend fun getDela() {
        val dela = delaRepository.getDelas(token = authRepository.getToken())
        viewState = if (dela != null) {
            viewState.copy(isLoading = true, dela = dela)
        } else {
            viewState.copy(isLoading = false, isError = true)
        }
    }
}