package es.kprops.view

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class PropertiesView {

    var log: String = "Init Properties View"

    private fun logea(t: String) {
        this.log += t
    }


    @Preview
    @Composable
    fun createView() {

        var resulttext by rememberSaveable { mutableStateOf("Init View") }

        MaterialTheme(colors = darkColors(background = Color.Black)) {
            Column {
                Row(
                    Modifier.background(color = Color(0xFFF8F7FF))
                    .height(130.dp)
                    .width(800.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    rowOne(resulttext, onNameChange = { resulttext = it })
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
    }

}