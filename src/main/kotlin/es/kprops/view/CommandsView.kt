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
import es.kprops.domain.api.antcases.AntUseCase
import es.kprops.domain.model.ant.AntResult
import kotlinx.coroutines.launch

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class CommandsView {

     var log: String = "Init Commands State"

    private fun logea(t: String) {
        this.log += t
    }

    @Preview
    @Composable
    fun createAntView() {

        var resulttext by rememberSaveable { mutableStateOf("Init State") }

        MaterialTheme(colors = darkColors(background = Color.Black)) {
            Column(Modifier.background(color = Color.White)
                           .width(800.dp),
                   Arrangement.Top,
                   Alignment.Start
            ) {
                Row(
                    Modifier.background(color = Color.White).width(800.dp),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                ) {
                    rowOne(resulttext, onNameChange = { resulttext = it })
                }

                Spacer(Modifier.height(20.dp))

                Row(
                    Modifier.background(color = Color.White).width(800.dp),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                ) {
                    rowTwo(resulttext, onNameChange = { resulttext = it })
                }

                Spacer(Modifier.height(20.dp))

                Row(
                    Modifier.background(color = Color.White).width(800.dp),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                ) {
                    rowThree(resulttext, onNameChange = { resulttext = it })
                }

                Spacer(Modifier.height(20.dp))

                Row(
                    Modifier.background(color = Color.White).width(800.dp),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                ) {
                    rowFour(resulttext, onNameChange = { resulttext = it })
                }

                Spacer(Modifier.height(20.dp))

                Row(
                    Modifier.background(color = Color.White).width(800.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    rowFive(resulttext, onNameChange = { resulttext = it })
                }

                Spacer(Modifier.height(50.dp))

                Row(Modifier.background(color = Color.White).width(800.dp),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.Top
                ) {
                    resultDataRow(log)
                }
            }
        }
    }

    /**
     * Row for GIT
     */
    @Composable
    private fun rowOne(t: String, onNameChange: (String) -> Unit) {

        val antUseCase: AntUseCase =  UseCaseFactory.getAntUseCase()
        val coroutineScope = rememberCoroutineScope()

        val gitButtonsColor =  ButtonDefaults.outlinedButtonColors(backgroundColor = Color(0xFF7BB661),
                                                                   contentColor = Color(0xFFF5F5F5),
                                                                   disabledContentColor = Color(0xFF666699))

        Spacer(Modifier.width(20.dp))

        OutlinedButton( modifier = Modifier.width(200.dp),
                        colors = gitButtonsColor,
                        onClick = {
                                   coroutineScope.launch {
                                       logea("\nStarting Git Pull-All")
                                       onNameChange("1.1.1")
                                       antUseCase.gitPullAll()
                                       logea("\nGit Pull-All working on")
                                       onNameChange("1.1.2")
                                   }
                                  }
        )
        {
            Text("Git Pull All")
        }

        Spacer(Modifier.width(20.dp))

        OutlinedButton( modifier = Modifier.width(200.dp),
            colors = gitButtonsColor,
            onClick = {
                coroutineScope.launch {
                    logea("\nStarting Git Pull-Kenobi")
                    onNameChange("1.2.1")
                    antUseCase.gitPullKenobi()
                    logea("\nGit Pull-Kenobi working on")
                    onNameChange("1.2.2")
                }
            }
        )
        {
            Text("Git Pull Kenobi")
        }

        Spacer(Modifier.width(10.dp))

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = gitButtonsColor,
            onClick = {
                        coroutineScope.launch {
                            logea("\nStarting Git Log")
                            onNameChange("1.3.1")
                            antUseCase.gitLog()
                            logea("\nGit Log working on")
                            onNameChange("1.3.2")
                       }
                     }
        )
        {
            Text("Git Log")
        }
    }

    /**
     * Row for Back
     */
    @Composable
    private fun rowTwo(t: String, onNameChange: (String) -> Unit) {
        val antUseCase: AntUseCase = UseCaseFactory.getAntUseCase()

        val coroutineScope = rememberCoroutineScope()

        val bakButtonsColor = ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color(0xFF387780),
            contentColor = Color(0xFFF5F5F5),
            disabledContentColor = Color(0XFFe83151)
        )

        Spacer(Modifier.width(20.dp))

        OutlinedButton( modifier = Modifier.width(200.dp),
            colors = bakButtonsColor,
            onClick = {
                coroutineScope.launch {
                    logea("\nStarting Back Build All")
                    onNameChange("2.1.1")
                    antUseCase.backBuildAll()
                    logea("\nBack is compiling")
                    onNameChange("2.1.2")
                }
            }
        )
        {
            Text("Back Build All")
        }
    }

    /**
     * Row For Kenobi 1
     */
    @Composable
    private fun rowThree(t: String, onNameChange: (String) -> Unit) {
        val antUseCase: AntUseCase =  UseCaseFactory.getAntUseCase()

        val coroutineScope = rememberCoroutineScope()

        val copyButtonsColor =  ButtonDefaults.outlinedButtonColors(backgroundColor = Color(0xFF387780),
                                                                    contentColor = Color(0xFFF5F5F5),
                                                                    disabledContentColor = Color(0XFFe83151))

        Spacer(Modifier.width(20.dp))

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = copyButtonsColor,
            onClick = {
                        coroutineScope.launch {
                            logea("\nStarting Open Kenobi Cmd")
                            onNameChange("2.1.1")
                            val r: AntResult = antUseCase.openKenobiCmd()
                            if("OK".equals(r.result)) {
                                logea("\nKenobi cmd opened yet")
                            }
                            else {
                                logea("\nKenobi cmd opened Action KO!!")
                            }
                            onNameChange("2.1.2")
                        }
                      }
        )
        {
            Text("Open Kenobi cmd")
        }

        Spacer(Modifier.width(10.dp))

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = copyButtonsColor,
            onClick = {
                        coroutineScope.launch {
                            logea("\nStarting kenobi Server")
                            onNameChange("2.21.1")
                            val r: AntResult = antUseCase.launchKenobi()
                            if("OK".equals(r.result)) {
                                logea("\nnKenobi server is starting")
                            }
                            else {
                                logea("\nnKenobi server failed to start, KO!!")
                            }
                            onNameChange("2.2.2")
                        }
                      }
        )
        {
            Text("Launch Server")
        }

        Spacer(Modifier.width(10.dp))

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = copyButtonsColor,
            onClick = {
                        coroutineScope.launch {
                            logea("\nLaunching kenobi Tests")
                            onNameChange("2.3.1")
                            val r: AntResult = antUseCase.launchKenobiTest()
                            if("OK".equals(r.result)) {
                                logea("\nKenobi tests running")
                            }
                            else {
                                logea("\nnTests script failed to start, KO!!")
                            }
                            onNameChange("2.3.2")
                        }
                      }
        )
        {
            Text("Launch Tests")
        }
    }

    /**
     * Row for Kenobi 2
     */
    @Composable
    private fun rowFour(t: String, onNameChange: (String) -> Unit) {
        val antUseCase: AntUseCase =  UseCaseFactory.getAntUseCase()

        val coroutineScope = rememberCoroutineScope()

        val copyButtonsColor =  ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color(0xFF9381ff),
            contentColor = Color(0xFFF5F5F5),
            disabledContentColor = Color(0XFFe83151))

        Spacer(Modifier.width(20.dp))

        OutlinedButton(modifier = Modifier.width(150.dp),
            colors = copyButtonsColor,
            onClick = {
                coroutineScope.launch {
                    logea("\nStarting Copy PPRD1 script")
                    onNameChange("3.1.1")
                    val r: AntResult = antUseCase.copyEnvPPRD1()
                    if ("OK".equals(r.result)) {
                        logea("\nCopying PPRD1 files")
                    } else {
                        logea("\nnCopy PPRD1 files script failed to start, KO!!")
                    }
                    onNameChange("3.1.2")
                }
            })
        {
            Text("Cp PPRD1")
        }

        Spacer(Modifier.width(10.dp))


        OutlinedButton(modifier = Modifier.width(150.dp),
            colors = copyButtonsColor,
            onClick = {
                coroutineScope.launch {
                    logea("\nStarting Copy SIT2 script")
                    onNameChange("3.2.1")
                    val r: AntResult = antUseCase.copyEnvSit2()
                    if ("OK".equals(r.result)) {
                        logea("\nCopying SIT2 files")
                    } else {
                        logea("\nnCopy SIT2 files script failed to start, KO!!")
                    }
                    onNameChange("3.2.2")
                }
            })
        {
            Text("Cp Sit2")
        }

        Spacer(Modifier.width(10.dp))


        OutlinedButton(modifier = Modifier.width(150.dp),
            colors = copyButtonsColor,
            onClick = {
                coroutineScope.launch {
                    logea("\nStarting Copy HID script")
                    onNameChange("3.3.1")
                    val r: AntResult = antUseCase.copyEnvSit2()
                    if ("OK".equals(r.result)) {
                        logea("\nCopying HID files")
                    } else {
                        logea("\nnCopy HID files script failed to start, KO!!")
                    }
                    onNameChange("3.3.2")
                }
            })
        {
            Text("Cp HID")
        }

        Spacer(Modifier.width(10.dp))


        OutlinedButton(modifier = Modifier.width(150.dp),
            colors = copyButtonsColor,
            onClick = {
                coroutineScope.launch {
                    logea("\nStarting Copy LOCAL script")
                    onNameChange("3.4.1")
                    val r: AntResult = antUseCase.copyEnvLocal()
                    if ("OK".equals(r.result)) {
                        logea("\nCopying LOCAL files")
                    } else {
                        logea("\nnCopy LOCAL files script failed to start, KO!!")
                    }
                    onNameChange("3.4.2")
                }
            })
        {
            Text("Cp Local")
        }
    }

    /**
     * row for Kenobi 3
     */
    @Composable
    private fun rowFive(t: String, onNameChange: (String) -> Unit) {
        val antUseCase: AntUseCase =  UseCaseFactory.getAntUseCase()

        val coroutineScope = rememberCoroutineScope()

        val copyButtonsColor =  ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color(0XFFe83151),
            contentColor = Color(0xFFF5F5F5),
            disabledContentColor = Color(0XFFe83151))

        Spacer(Modifier.width(20.dp))

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = copyButtonsColor,
            onClick = {
                coroutineScope.launch {
                    logea("\nStarting Install Script")
                    onNameChange("4.1.1")
                    val r: AntResult = antUseCase.launchKenobiInstall()
                    if ("OK".equals(r.result)) {
                        logea("\nMaking Install")
                    } else {
                        logea("\nnInstall script failed to start, KO!!")
                    }
                    onNameChange("4.1.2")
                }
            })
        {
            Text("Make Install")
        }

        Spacer(Modifier.width(10.dp))

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = copyButtonsColor,
            onClick = {
                coroutineScope.launch {
                    logea("\nStarting Prod:build")
                    onNameChange("4.2.1")
                    val r: AntResult = antUseCase.buildProKenobi()
                    if ("OK".equals(r.result)) {
                        logea("\nMaking Prod:build")
                    } else {
                        logea("\nnProd:build script failed to start, KO!!")
                    }
                    onNameChange("4.2.2")
                }
            })
        {
            Text("Build Prod")
        }
    }

    /**
     * Row for log
     */
    @Composable
    private fun resultDataRow(log: String) {

        Column {
            Text(
                text = formatLogText(log),
                modifier = Modifier.width(500.dp).height(200.dp).padding(PaddingValues(start = 25.dp)),
                style = MaterialTheme.typography.body2,
                color = Color.DarkGray,
                maxLines = 8
           )
        }
    }
}