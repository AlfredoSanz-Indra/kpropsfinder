package es.kprops.view

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
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

         var resulttext by remember { mutableStateOf("Init State") }


        MaterialTheme(colors = darkColors(background = Color.Black)) {
            Column {
                Row(Modifier.background(color = Color.White)) {
                    rowOne()
                }

                Spacer(Modifier.height(20.dp))

                Row(Modifier.background(color = Color.White)) {
                    rowTwo(resulttext = resulttext, onNameChange = { resulttext = it })
                }

                Spacer(Modifier.height(20.dp))

                Row(Modifier.background(color = Color.White)) {
                    rowThree()
                }

                Spacer(Modifier.height(20.dp))

                Row(Modifier.background(color = Color.White)) {
                    rowFour()
                }

                Spacer(Modifier.height(50.dp))

                Row(Modifier.background(color = Color.White)) {
                    resultDataRow(resulttext = resulttext, onNameChange = { resulttext = it })
                }
            }
        }
    }

    @Composable
    private fun rowOne() {

        val antUseCase: AntUseCase =  UseCaseFactory.getAntUseCase()

        val gitButtonsColor =  ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color(0xFF7BB661),
            contentColor = Color(0xFFF5F5F5),
            disabledContentColor = Color(0xFF666699))

        Spacer(Modifier.width(20.dp))

        OutlinedButton( modifier = Modifier.width(200.dp),
            colors = gitButtonsColor,
            onClick = {
                antUseCase.gitPullAll()
            }
        )
        {
            Text("Git Pull All")
        }

        Spacer(Modifier.width(10.dp))

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = gitButtonsColor,
            onClick = {
                antUseCase.gitLog()
            })
        {
            Text("Git Log")
        }
    }

    @Composable
    private fun rowTwo(resulttext: String, onNameChange: (String) -> Unit) {

        val antUseCase: AntUseCase =  UseCaseFactory.getAntUseCase()

        val copyButtonsColor =  ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color(0xFF387780),
            contentColor = Color(0xFFF5F5F5),
            disabledContentColor = Color(0XFFe83151))

        Spacer(Modifier.width(20.dp))

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = copyButtonsColor,
            onClick = {
                val t = "\nOpening kenobi Cmd"
                onNameChange ( t )
                antUseCase.openKenobiCmd()
                val x: String = t + "\nKenobi cmd opened yet"
                onNameChange ( x )
            })
        {
            Text("Open Kenobi cmd")
        }

        Spacer(Modifier.width(10.dp))


        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = copyButtonsColor,
            onClick = {
                antUseCase.launchKenobi()
            })
        {
            Text("Launch Server")
        }

        Spacer(Modifier.width(10.dp))

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = copyButtonsColor,
            onClick = {
                antUseCase.launchKenobiTest()
            })
        {
            Text("Launch Tests")
        }
    }

    @Composable
    private fun rowThree() {
        val antUseCase: AntUseCase =  UseCaseFactory.getAntUseCase()

        val copyButtonsColor =  ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color(0xFF9381ff),
            contentColor = Color(0xFFF5F5F5),
            disabledContentColor = Color(0XFFe83151))

        Spacer(Modifier.width(20.dp))

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = copyButtonsColor,
            onClick = {
                antUseCase.copyEnvPPRD1()
            })
        {
            Text("Copy PPRD1")
        }

        Spacer(Modifier.width(10.dp))


        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = copyButtonsColor,
            onClick = {
                antUseCase.copyEnvSit2()
            })
        {
            Text("Copy Sit2")
        }
    }

    @Composable
    private fun rowFour() {
        val antUseCase: AntUseCase =  UseCaseFactory.getAntUseCase()

        val copyButtonsColor =  ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color(0XFFe83151),
            contentColor = Color(0xFFF5F5F5),
            disabledContentColor = Color(0XFFe83151))

        Spacer(Modifier.width(20.dp))

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = copyButtonsColor,
            onClick = {
                antUseCase.launchKenobiInstall()
            })
        {
            Text("Make Install")
        }

        Spacer(Modifier.width(10.dp))

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = copyButtonsColor,
            onClick = {
                antUseCase.buildProKenobi()
            })
        {
            Text("Build Prod")
        }
    }

    @Composable
    private fun resultDataRow(resulttext: String, onNameChange: (String) -> Unit) {

        Column {
            Text(
                text = resulttext,
                modifier = Modifier.width(500.dp),
                style = MaterialTheme.typography.body1,
                color = Color.Magenta,
                maxLines = 5
           )
        }
    }
}