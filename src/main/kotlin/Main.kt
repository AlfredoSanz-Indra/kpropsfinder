import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyShortcut
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import es.kprops.view.creatDefaultView
import es.kprops.view.createAntView


const val actionAnt: String = "ANT"
const val actionProp: String = "prop"

/**
 * @author Alfredo Sanz
 * @date Nov 2021
 */
@Preview
@Composable
private fun app(action: String) {

    if(actionAnt == action) {
        createAntView()
    }
    else {
        creatDefaultView(action)
    }

}

@OptIn(ExperimentalComposeUiApi::class)
fun main() = application {

    var action by remember { mutableStateOf("Last action: None") }

    Window(onCloseRequest = ::exitApplication,
           title = "VF Alfred toolbox  v0.1",
           state = rememberWindowState(width = 600.dp, height = 600.dp)
    ) {
        MenuBar {
            Menu("Scopes", mnemonic = 'F') {
                Item("ANT commands", onClick = { action = actionAnt }, shortcut = KeyShortcut(Key.C, ctrl = true))
                Item("Properties", onClick = { action = actionProp }, shortcut = KeyShortcut(Key.V, ctrl = true))
            }
        }
        app(action)
    }
}
