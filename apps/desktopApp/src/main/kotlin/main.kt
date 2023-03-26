import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication
import ru.andvl.mppapp.setupThemedNavigation

fun main() = singleWindowApplication(
    state = WindowState(size = DpSize(500.dp, 500.dp))
) {
    setupThemedNavigation()
}
