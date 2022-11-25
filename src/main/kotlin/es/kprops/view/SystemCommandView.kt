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
import es.kprops.core.di.UseCaseFactory
import es.kprops.core.formatLogText
import es.kprops.domain.api.systemcases.SystemUseCase
import es.kprops.domain.model.system.SystemResult
import kotlinx.coroutines.launch

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class SystemCommandView {

    var log: String = "Init System State"

    private fun logea(t: String) {
        this.log += t
    }

    @Preview
    @Composable
    fun createView() {

        var resulttext by rememberSaveable { mutableStateOf("Init State") }

        MaterialTheme(colors = darkColors(background = Color.Black)) {
            Column(Modifier.background(color = Color.White)
                           .width(800.dp),
                            Arrangement.Top,
                            Alignment.CenterHorizontally
            ) {
                Row(Modifier.background(color = Color.White)
                            .width(800.dp),
                            Arrangement.Center,
                            Alignment.Top
                ) {
                    rowOne(resulttext, onNameChange = { resulttext = it })
                }

                Spacer(Modifier.height(50.dp))

                Row(Modifier.background(color = Color.White)
                            .width(800.dp),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.Top
                ) {
                    resultDataRow(log)
                }
            }
        }
    }

    @Composable
    private fun rowOne(t: String, onNameChange: (String) -> Unit) {
        val systemUseCase: SystemUseCase =  UseCaseFactory.getSystemUseCase()

        val coroutineScope = rememberCoroutineScope()

        val copyButtonsColor =  ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color(0XFF119090),
            contentColor = Color(0xFFF5F5F5),
            disabledContentColor = Color(0XFFe83151))

        Spacer(Modifier.width(20.dp))

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = copyButtonsColor,
            onClick = {
                coroutineScope.launch {
                    logea("\nStarting Script to connect VPN")
                    onNameChange("1.1.1")
                    val r: SystemResult = systemUseCase.startVpn()
                    if("OK".equals(r.result)) {
                        logea("\nScript to connect VPN running")
                    }
                    else {
                        logea("\nnVPN starter script failed to start, KO!!")
                    }
                    onNameChange("1.1.2")
                }
            })
        {
            Text("Connect VPN")
        }

        Spacer(Modifier.width(10.dp))

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = copyButtonsColor,
            onClick = {
                coroutineScope.launch {
                    logea("\nStarting Script to Disconnect VPN")
                    onNameChange("1.2.1")
                    val r: SystemResult = systemUseCase.stopVpn()
                    if("OK".equals(r.result)) {
                        logea("\nScript to Disconnect VPN running")
                    }
                    else {
                        logea("\nnVPN stopper script failed to start, KO!!")
                    }
                    onNameChange("1.2.2")
                }
            })
        {
            Text("Disconnect VPN")
        }

        Spacer(Modifier.width(10.dp))

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = copyButtonsColor,
            onClick = {
                coroutineScope.launch {
                    logea("\nStarting Script to open Bridges")
                    onNameChange("1.3.1")
                    val r: SystemResult = systemUseCase.openBridges()
                    if("OK".equals(r.result)) {
                        logea("\nScript to open Bridges running")
                    }
                    else {
                        logea("\nScript to open Bridges failed to start, KO!!")
                    }
                    onNameChange("1.3.2")
                }
            })
        {
            Text("Open Bridges")
        }
    }

    @Composable
    private fun resultDataRow(resulttext: String) {

        Column {
            Text(
                text = formatLogText(log),
                modifier = Modifier.width(500.dp).height(200.dp).padding(PaddingValues(start = 25.dp)),
                style = MaterialTheme.typography.body2,
                color = Color.DarkGray,
                maxLines = 10
            )
        }
    }
}