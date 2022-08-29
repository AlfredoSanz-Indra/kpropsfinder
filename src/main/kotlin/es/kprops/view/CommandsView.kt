package es.kprops.view

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import es.kprops.core.di.UseCaseFactory
import es.kprops.domain.api.antcases.AntUseCase

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class CommandsView {


    @Preview
    @Composable
    fun createAntView() {

        var resulttext by rememberSaveable { mutableStateOf("Init State") }

        MaterialTheme(colors = darkColors(background = Color.Black)) {
            Column {
                Row(Modifier.background(color = Color.White)) {
                    rowOne(resulttext = resulttext, onNameChange = { resulttext = it })
                }

                Spacer(Modifier.height(20.dp))

                Row(Modifier.background(color = Color.White)) {
                    rowTwo(resulttext = resulttext, onNameChange = { resulttext = it })
                }

                Spacer(Modifier.height(20.dp))

                Row(Modifier.background(color = Color.White)) {
                    rowThree(resulttext = resulttext, onNameChange = { resulttext = it })
                }

                Spacer(Modifier.height(20.dp))

                Row(Modifier.background(color = Color.White)) {
                    rowFour(resulttext = resulttext, onNameChange = { resulttext = it })
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
        val antUseCase: AntUseCase =  UseCaseFactory.getAntUseCase()
        var t: String = resulttext

        val gitButtonsColor =  ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color(0xFF7BB661),
            contentColor = Color(0xFFF5F5F5),
            disabledContentColor = Color(0xFF666699))

        Spacer(Modifier.width(20.dp))

        OutlinedButton( modifier = Modifier.width(200.dp),
            colors = gitButtonsColor,
            onClick = {
                t += "\nStarting Git Pull All"
                onNameChange ( t )
                antUseCase.gitPullAll()
                onNameChange ( t + "\nGit Pull All execuiting" )
            }
        )
        {
            Text("Git Pull All")
        }

        Spacer(Modifier.width(10.dp))

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = gitButtonsColor,
            onClick = {
                t += "\nStarting Git Log"
                antUseCase.gitLog()
                onNameChange ( t + "\nGit Log running" )
            })
        {
            Text("Git Log")
        }
    }

    @Composable
    private fun rowTwo(resulttext: String, onNameChange: (String) -> Unit) {
        val antUseCase: AntUseCase =  UseCaseFactory.getAntUseCase()
        var t: String = resulttext

        val copyButtonsColor =  ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color(0xFF387780),
            contentColor = Color(0xFFF5F5F5),
            disabledContentColor = Color(0XFFe83151))

        Spacer(Modifier.width(20.dp))

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = copyButtonsColor,
            onClick = {
                t += "\nOpening kenobi Cmd"
                onNameChange ( t )
                antUseCase.openKenobiCmd()
                onNameChange ( t + "\nKenobi cmd opened yet" )
            })
        {
            Text("Open Kenobi cmd")
        }

        Spacer(Modifier.width(10.dp))


        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = copyButtonsColor,
            onClick = {
                t += "\nLaunching kenobi Server"
                onNameChange ( t )
                antUseCase.launchKenobi()
                onNameChange ( t + "\nKenobi server is starting")
            })
        {
            Text("Launch Server")
        }

        Spacer(Modifier.width(10.dp))

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = copyButtonsColor,
            onClick = {
                t += "\nLaunching kenobi Tests"
                onNameChange ( t )
                antUseCase.launchKenobiTest()
                onNameChange ( t + "\nKenobi tests script is running")
            })
        {
            Text("Launch Tests")
        }
    }

    @Composable
    private fun rowThree(resulttext: String, onNameChange: (String) -> Unit) {
        val antUseCase: AntUseCase =  UseCaseFactory.getAntUseCase()
        var t: String = resulttext

        val copyButtonsColor =  ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color(0xFF9381ff),
            contentColor = Color(0xFFF5F5F5),
            disabledContentColor = Color(0XFFe83151))

        Spacer(Modifier.width(20.dp))

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = copyButtonsColor,
            onClick = {
                t += "\nStarting script copy Env PPRD1"
                onNameChange ( t )
                antUseCase.copyEnvPPRD1()
                onNameChange ( t + "\nCoping Files Env PPRD1")
            })
        {
            Text("Copy PPRD1")
        }

        Spacer(Modifier.width(10.dp))


        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = copyButtonsColor,
            onClick = {
                t += "\nStarting script copy Env SIT2"
                onNameChange ( t )
                antUseCase.copyEnvSit2()
                onNameChange ( t + "\nCoping Files Env SIT2")
            })
        {
            Text("Copy Sit2")
        }
    }

    @Composable
    private fun rowFour(resulttext: String, onNameChange: (String) -> Unit) {
        val antUseCase: AntUseCase =  UseCaseFactory.getAntUseCase()
        var t: String = resulttext

        val copyButtonsColor =  ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color(0XFFe83151),
            contentColor = Color(0xFFF5F5F5),
            disabledContentColor = Color(0XFFe83151))

        Spacer(Modifier.width(20.dp))

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = copyButtonsColor,
            onClick = {
                t += "\nStarting Install Script"
                onNameChange ( t )
                antUseCase.launchKenobiInstall()
                onNameChange ( t + "\nInstall Script Running")
            })
        {
            Text("Make Install")
        }

        Spacer(Modifier.width(10.dp))

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = copyButtonsColor,
            onClick = {
                t += "\nStarting Prod compilation script"
                onNameChange ( t )
                antUseCase.buildProKenobi()
                onNameChange ( t + "\nProd compilation script running")
            })
        {
            Text("Build Prod")
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

    private fun formatLogText(input: String): String {
        var result = input
        val tList: List<String> = input.split("\n")
        if(tList.size > 4) {
            val newList: List<String> = tList.subList(tList.size - 5, tList.size)
            result = ""
            newList.forEach {
                result += "\n" + it
            }
        }

        return result
    }
}