package suponev.ilya.tutor_db

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "TutorDB",
    ) {
        App()
    }
}
