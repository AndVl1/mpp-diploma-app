package ru.andvl.mppapp.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.andvl.mppapp.theme.Theme

@Composable
fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: @Composable (() -> Unit)? = null,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0xFF1F2430),
            textColor = Color(0xFF696C75),
            cursorColor = Theme.colors.highlightTextColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        placeholder = placeholder,
        shape = RoundedCornerShape(10.dp),
    )
}