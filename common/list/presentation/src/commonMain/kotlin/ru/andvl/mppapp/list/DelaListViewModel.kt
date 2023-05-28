package ru.andvl.mppapp.list

import com.adeo.kviewmodel.BaseSharedViewModel
import com.adeo.kviewmodel.KViewModel
import di.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
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
            is DelaEvent.Refresh -> {
                viewState = viewState.copy(isLoading = true, dela = null, isError = false)
                viewModelScope.launch {
                    getDela()
                }
            }
            is DelaEvent.DeloClick -> {
                viewAction = DelaAction.OpenDetails(viewEvent.id)
            }
            is DelaEvent.DeloOpen -> {
                viewAction = null
            }
        }
    }

    private suspend fun checkLogin() {
        if (authRepository.isUserLoggedIn()) {
            try {
                authRepository.whoAmI()
            } catch (e: Exception) {
                try {
                    authRepository.login()
                } catch (e: Exception) {
                    // плохо :(
                    // игнор запросов, чтобы взять данные из БД
                }
            }
        } else {
            try {
                authRepository.login()
            } catch (e: Exception) {
                // плохо :(
                // игнор запросов, чтобы взять данные из БД
            }
        }
    }

    private suspend fun getDela() {
        val now = Clock.System.now()
        val datetime = now.toLocalDateTime(TimeZone.currentSystemDefault())
        val dela = delaRepository.getDelas(token = authRepository.getToken())
        viewState = if (dela != null) {
            viewState.copy(
                isLoading = false,
                dela = dela,
                date = "${datetime.dayOfMonth}.${datetime.monthNumber}"
            )
        } else {
            viewState.copy(isLoading = false, isError = true)
        }
    }
}
