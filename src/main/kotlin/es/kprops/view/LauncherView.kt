package es.kprops.view

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class LauncherView {

    var log: String = "Init Launcher View"

    var theview: Number = 0

    private fun logea(t: String) {
        this.log += t
    }


    @Preview
    @Composable
    fun createView() {

        var resulttext by rememberSaveable { mutableStateOf("Init View") }

        MaterialTheme(colors = darkColors(background = Color.Black)) {
            Column {
                Row(Modifier.background(color = Color(0xFFF8F7FF))
                            .height(130.dp)
                            .width(800.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                  rowOne(resulttext, onNameChange = { resulttext = it })
                }

                if(1 == theview) {
                    Spacer(Modifier.height(20.dp))

                    Row(Modifier.background(color = Color.White)) {
                        rowTwo()
                    }
                }

                if(2 == theview) {
                    Spacer(Modifier.height(20.dp))

                    Row(Modifier.background(color = Color.White)) {
                        rowThree()
                    }
                }
            }
        }
    }

    @Composable
    private fun rowOne(t: String, onNameChange: (String) -> Unit) {

        Spacer(Modifier.width(20.dp))

        val gitButtonsColor =  ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color(0xFF41521F),
            contentColor = Color(0xFFEFF2EF),
            disabledContentColor = Color(0xFF41521F))

        Spacer(Modifier.width(20.dp))

        OutlinedButton( modifier = Modifier.width(200.dp)
                                           .height(70.dp),
            colors = gitButtonsColor,
            onClick =  {
                theview = 2
                onNameChange("1.1")
            }
        ) {
            Text("Ant Commands")
        }

        Spacer(Modifier.width(10.dp))

        OutlinedButton(modifier = Modifier.width(200.dp)
                                          .height(70.dp),
            colors = gitButtonsColor,
            onClick =  {
                theview = 1
                onNameChange("1.2")
            }
        ) {
            Text("System Commands")
        }
    }

    @Composable
    private fun rowTwo() {
        val v = SystemCommandView()
        v.createView()
    }

    @Composable
    private fun rowThree() {
        val v = CommandsView()
        v.createAntView()
    }
}