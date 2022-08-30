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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import es.kprops.core.di.UseCaseFactory
import es.kprops.core.formatLogText
import es.kprops.domain.api.systemcases.SystemUseCase

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class SystemCommandView {

    @Preview
    @Composable
    fun createView() {

        var resulttext by rememberSaveable { mutableStateOf("Init State") }

        MaterialTheme(colors = darkColors(background = Color.Black)) {
            Column {
                Row(Modifier.background(color = Color.White)) {
                    rowOne(resulttext = resulttext, onNameChange = { resulttext = it })
                }

                Spacer(Modifier.height(50.dp))

                Row(Modifier.background(color = Color.White)) {
                    resultDataRow(resulttext = resulttext)
                }
            }
        }
    }

    @Composable
    private fun rowOne(resulttext: String, onNameChange: (String) -> Unit) {
        val systemUseCase: SystemUseCase =  UseCaseFactory.getSystemUseCase()
        var t: String = resulttext

        val copyButtonsColor =  ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color(0XFF119090),
            contentColor = Color(0xFFF5F5F5),
            disabledContentColor = Color(0XFFe83151))

        Spacer(Modifier.width(20.dp))

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = copyButtonsColor,
            onClick = {
                t += "\nStarting Starting script to connect VPN"
                onNameChange ( t )
                systemUseCase.startVpn()
                onNameChange ("$t\nConnection to VPN working on")
            })
        {
            Text("Connect VPN")
        }

        Spacer(Modifier.width(10.dp))

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = copyButtonsColor,
            onClick = {
                t += "\nStarting script to disconnect VPN"
                onNameChange ( t )
                systemUseCase.stopVpn()
                onNameChange ("$t\nVPN disconnecting")
            })
        {
            Text("Disconnect VPN")
        }
    }

    @Composable
    private fun resultDataRow(resulttext: String) {

        Column {
            Text(
                text = formatLogText(resulttext),
                modifier = Modifier.width(500.dp).padding(PaddingValues(start = 25.dp)),
                style = MaterialTheme.typography.body2,
                color = Color.DarkGray,
                maxLines = 6
            )
        }
    }


}