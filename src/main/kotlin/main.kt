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
import es.kprops.core.resources.TheResources
import es.kprops.view.*
import java.util.*


const val actionProp: String = "prop"
const val actionLauncher: String = "LAUNCHER"

/**
 * @author Alfredo Sanz
 * @date Nov 2021
 */
@Preview
@Composable
private fun app(action: String) {

    when(action) {
        actionProp -> {
            val v = PropertiesView()
            v.createView()
        }
        actionLauncher -> {
            val v = LauncherView()
            v.createView()
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
fun main() = application {

    var action by remember { mutableStateOf(actionLauncher) }

    Window(onCloseRequest = ::exitApplication,
        title = "VF Alfred toolbox  v1.5.5",
        state = rememberWindowState(width = 800.dp, height = 650.dp)
    ) {
        MenuBar {
            Menu("What's next", mnemonic = 'F') {
                Item("Launcher", onClick = { action = actionLauncher }, shortcut = KeyShortcut(Key.C, ctrl = true))
                Item("Properties", onClick = { action = actionProp }, shortcut = KeyShortcut(Key.V, ctrl = true))
            }
        }
        app(action)
    }

    println("initializing -> reading props")
    val prop: Properties = TheResources.getConstantsProp()
    println(prop)
}
