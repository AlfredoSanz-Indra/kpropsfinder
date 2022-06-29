package es.kprops.view

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
    MaterialTheme {

        Column(Modifier.width(500.dp)) {
            Row (Modifier.width(500.dp)
                         .background(color = Color.Cyan)) {

                Spacer(Modifier.width(20.dp))

                OutlinedButton(
                    modifier = Modifier.width(200.dp),
                    onClick = {
                    })
                    {
                        Text("Pull All")
                    }

                Spacer(Modifier.width(10.dp))

                OutlinedButton(
                    modifier = Modifier.width(200.dp),
                    onClick = {
                    })
                    {
                        Text("Log All 2D")
                    }

                Spacer(Modifier.width(20.dp))
            }

            Spacer(Modifier.height(10.dp))

            Row(
                Modifier.width(300.dp)
                        .background(color= Color.LightGray)) {

                OutlinedButton( modifier = Modifier.width(200.dp),
                    onClick = {
                    })
                {
                    Text("Copy PPRD1")
                }
            }
        }
    }
}
