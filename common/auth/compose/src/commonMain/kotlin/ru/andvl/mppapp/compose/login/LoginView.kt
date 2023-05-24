package ru.andvl.mppapp.compose.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.andvl.mppapp.auth.models.LoginEvent
import ru.andvl.mppapp.auth.models.LoginViewState
import ru.andvl.mppapp.components.AppTextField

@Composable
fun LoginView(
    state: LoginViewState,
    eventHandler: (LoginEvent) -> Unit
) = Column(
    modifier = Modifier
        .fillMaxSize(),
    verticalArrangement = Arrangement.SpaceBetween
) {
    Column {
        AppTextField(
            value = state.login,
            onValueChange = { eventHandler.invoke(LoginEvent.LoginChanged(it)) },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Your login", color = MaterialTheme.colors.primaryVariant) }
        )
        AppTextField(
            value = state.password,
            onValueChange = { eventHandler.invoke(LoginEvent.PasswordChanged(it)) },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Your password", color = MaterialTheme.colors.primaryVariant) }
        )
        Button(onClick = { eventHandler.invoke(LoginEvent.LoginClicked) }) {
            Text("Login")
        }
    }
}
