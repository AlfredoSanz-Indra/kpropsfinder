package es.kprops.view

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * @author Alfredo Sanz
 * @date Jun 2022
 */

@Preview
@Composable
fun creatDefaultView(action: String) {
    var theText by remember { mutableStateOf("default") }

    MaterialTheme {

        Column(Modifier.width(300.dp)) {
            Row (
                Modifier.width(300.dp)
                .background(color = Color.Cyan)) {
                Text("Go through!")
            }

            Spacer(Modifier.height(10.dp))

            Row(
                Modifier.width(300.dp)
                .background(color= Color.LightGray)) {
                Button( modifier = Modifier.width(200.dp),
                    onClick = {
                        theText = action

                    })
                {
                    Text(theText)
                }
            }
        }

        Column(Modifier.absolutePadding (300.dp)) {
            Row {
                Text("Texto columna 2")
            }
            Row {
                Text("second line")
            }
        }
    }
}