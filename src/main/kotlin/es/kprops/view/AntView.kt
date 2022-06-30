package es.kprops.view

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


/**
 * @author Alfredo Sanz
 * @date Jun 2022
 */


@Preview
@Composable
fun createAntView() {
    val gitButtonsColor =  ButtonDefaults.outlinedButtonColors(
        backgroundColor = Color(0xFF7BB661),
        contentColor = Color(0xFFF5F5F5),
        disabledContentColor = Color(0xFF666699))
    val copyButtonsColor =  ButtonDefaults.outlinedButtonColors(
        backgroundColor = Color(0XFFe83151),
        contentColor = Color(0xFFF5F5F5),
        disabledContentColor = Color(0XFFe83151))

    MaterialTheme {
        Column {
            Row(Modifier.background(color = Color.White)) {
                Spacer(Modifier.width(20.dp))

                OutlinedButton( modifier = Modifier.width(200.dp),
                    colors = gitButtonsColor,
                    onClick = {
                    })
                {
                    Text("Git Pull All")
                }

                Spacer(Modifier.width(10.dp))

                OutlinedButton(modifier = Modifier.width(200.dp),
                    colors = gitButtonsColor,
                    onClick = {
                    })
                {
                    Text("Git Log")
                }
            }

            Spacer(Modifier.height(20.dp))


            Row(Modifier.background(color = Color.White)) {

                Spacer(Modifier.width(20.dp))

                OutlinedButton(modifier = Modifier.width(200.dp),
                    colors = copyButtonsColor,
                    onClick = {
                    })
                {
                    Text("Copy PPRD1")
                }

                Spacer(Modifier.width(10.dp))

                OutlinedButton(modifier = Modifier.width(200.dp),
                    colors = copyButtonsColor,
                    onClick = {
                    })
                {
                    Text("Copy SIT2")
                }
            }
        }
    }
}