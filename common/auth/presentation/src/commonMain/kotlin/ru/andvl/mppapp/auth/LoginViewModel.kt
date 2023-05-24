package ru.andvl.mppapp.auth

import com.adeo.kviewmodel.BaseSharedViewModel
import di.Inject
import kotlinx.coroutines.launch
import ru.andvl.mppapp.auth.exceptions.AuthException
import ru.andvl.mppapp.auth.models.LoginAction
import ru.andvl.mppapp.auth.models.LoginEvent
import ru.andvl.mppapp.auth.models.LoginViewState
import ru.andvl.mppapp.auth.repository.AuthRepository

class LoginViewModel : BaseSharedViewModel<LoginViewState, LoginAction, LoginEvent>(
    initialState = LoginViewState("mobile-app", "m0b1le0323")
) {
    private val authRepository: AuthRepository = Inject.instance()

    init {
        checkLogin()
    }

    override fun obtainEvent(viewEvent: LoginEvent) {
         when (viewEvent) {
            LoginEvent.LoginClicked -> {
                sendLogin()
            }
            is LoginEvent.LoginChanged -> viewState = viewState.copy(login = viewEvent.value)
            is LoginEvent.PasswordChanged -> viewState = viewState.copy(password = viewEvent.value)
        }
    }

    private fun sendLogin() {
        viewState = viewState.copy(isSending = true)
        viewModelScope.launch {
            try {
                val resp = authRepository.login(viewState.login, viewState.password)
                if (resp.accessToken.isNotEmpty()) {
                    viewState = viewState.copy(login = "mobile-app", password = "m0b1le0323", isSending = false)
                    viewAction = LoginAction.OpenMainFlow
                }
            } catch (e: AuthException) {
                viewState = when (e) {
                    is AuthException.OtherException -> viewState.copy(isSending = false)
                    AuthException.TokenExpiredException -> viewState.copy(isSending = false)
                }
            }
        }
    }

    private fun checkLogin() {
        viewModelScope.launch {
            val whoAmI = kotlin.runCatching {
                authRepository.whoAmI()
            }.exceptionOrNull()
            if (whoAmI == null) {
                viewAction = LoginAction.OpenMainFlow
            }
        }
    }
}
