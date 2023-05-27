package ru.andvl.mppapp.details

import com.adeo.kviewmodel.BaseSharedViewModel
import di.Inject
import kotlinx.coroutines.launch
import ru.andvl.mppapp.auth.repository.AuthRepository
import ru.andvl.mppapp.details.api.DeloDetailsRepository
import ru.andvl.mppapp.details.models.DetailsAction
import ru.andvl.mppapp.details.models.DetailsEvent
import ru.andvl.mppapp.details.models.DetailsViewState

class DetailsScreenViewModel(
    private val id: Int
) : BaseSharedViewModel<DetailsViewState, DetailsAction, DetailsEvent>(
    initialState = DetailsViewState()
) {
    private val authRepository: AuthRepository = Inject.instance()
    private val detailsRepository: DeloDetailsRepository = Inject.instance()

    init {
        viewModelScope.launch {
            viewState = viewState.copy(isLoading = true)
            checkLogin()
            getDetails(id)
        }
    }

    override fun obtainEvent(viewEvent: DetailsEvent) {
        when (viewEvent) {
            is DetailsEvent.BackPressed -> viewAction = DetailsAction.BackClicked
        }
    }

    private suspend fun getDetails(id: Int) {
        val details = detailsRepository.getDelo(id, authRepository.getToken())
        viewState = if (details != null) {
            viewState.copy(
                isLoading = false,
                isError = false,
                details = details
            )
        } else {
            viewState.copy(
                isError = true,
                isLoading = false,
                details = null,
            )
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
                }
            }
        } else {
            try {
                authRepository.login()
            } catch (e: Exception) {
                // плохо :(
            }
        }
    }
}