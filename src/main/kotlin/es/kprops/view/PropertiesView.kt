package es.kprops.view

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import es.kprops.core.di.UseCaseFactory
import es.kprops.core.formatLogText
import es.kprops.domain.api.propcases.PropUseCase
import kotlinx.coroutines.launch

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class PropertiesView {

    var log: String = "Init Properties View"

    lateinit var selectProp: String
    lateinit var selectEnv: String

    private fun logea(t: String) {
        this.log += t
    }

    private fun setProperty(t: String) {
        this.selectProp = t
    }

    private fun setEnvironment(t: String) {
        this.selectEnv = t
    }

    @Preview
    @Composable
    fun createView() {

        var resultProp by rememberSaveable { mutableStateOf("Init") }
        var resultBut by rememberSaveable { mutableStateOf("Init") }

        MaterialTheme(colors = darkColors(background = Color.Black)) {
            Column(Modifier.background(color = Color.White)
                            .width(800.dp),
                            Arrangement.Top,
                            Alignment.Start
            ) {
                //TITULO
                Row( Modifier.background(color = Color.White)
                             .width(800.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    rowZero()
                }

                Spacer(Modifier.height(20.dp))

                //PROPERTY
                Row( Modifier.background(color = Color.White)
                             .width(800.dp),
                     horizontalArrangement = Arrangement.Start,
                     verticalAlignment = Alignment.CenterVertically
                ) {
                    rowOne( onNameChange = { resultProp = it })
                }

                Spacer(Modifier.height(20.dp))

                //ENVIRONMENT
                Row(
                    Modifier.background(color = Color.White)
                            .width(800.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    rowTwo()
                }

                Spacer(Modifier.height(20.dp))

                //BUTTON
                Row(
                    Modifier.background(color = Color.White)
                            .width(800.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    rowThree(resultBut, onNameChange = { resultBut = it })
                }

                //LOG
                Row(Modifier.background(color = Color.White).width(800.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Top
                ) {
                    resultDataRow(log)
                }
            }
        }
    }

    @Composable
    private fun rowZero() {

        Spacer(Modifier.width(20.dp).height(20.dp))

        Text(text = "Properties Finder",
             color = Color.Black,
             fontSize = 30.sp,
             fontStyle = FontStyle.Normal,
             fontWeight = FontWeight.Bold,
             fontFamily = FontFamily.Serif
        )
    }

    @Composable
    private fun rowOne(onNameChange: (String) -> Unit) {

        Spacer(Modifier.width(20.dp).height(20.dp))

        val maxLength = 30
        var textF by rememberSaveable { mutableStateOf(TextFieldValue("", TextRange(0, 7))) }

        OutlinedTextField(
            value = textF,
            modifier = Modifier.width(600.dp),
            onValueChange = {
                             if (it.text.length <= maxLength) {
                                textF = it
                                this.setProperty(textF.text)
                                onNameChange("1.1.1")
                             }
                            },
            label = { Text("Property name") },
            shape = MaterialTheme.shapes.small,
            placeholder = { Text(text = "*Property name") },
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = Color(0xFF7BB661),
                                                               placeholderColor = Color(0xFF7BB661),
                                                               focusedLabelColor =  Color(0xFF7BB661),
                                                               unfocusedLabelColor = Color.Gray,
                                                               unfocusedBorderColor = Color.LightGray,
                                                               disabledPlaceholderColor = Color.LightGray,
                                                               textColor = Color.Black,
                                                               disabledTextColor = Color.Gray
                                                               )
        )
    }

    @Composable
    private fun rowTwo() {

        Spacer(Modifier.width(20.dp).height(20.dp))

        val radioOptions = listOf("PPRD1", "SIT1", "SIT2")
        val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }

        setEnvironment(selectedOption) //Default value

        Column(Modifier.selectableGroup()) {
            Row(
                Modifier.background(color = Color.White).width(800.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                radioOptions.forEach { text ->
                    Column(
                        Modifier.height(56.dp)
                                .selectable(
                                            selected = (text == selectedOption),
                                            onClick = {
                                                        setEnvironment(text)
                                                        onOptionSelected(text)
                                                      },
                                            role = Role.RadioButton
                            )
                            .padding(horizontal = 16.dp)
                    ) {
                        Row {
                            RadioButton(
                                selected = (text == selectedOption),
                                onClick = null,
                                colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF7BB661),
                                                                    unselectedColor = Color.Gray,
                                                                    disabledColor = Color.Gray
                                                                   )
                            )
                            Text(
                                text = text,
                                style = MaterialTheme.typography.body1.merge(),
                                modifier = Modifier.padding(start = 5.dp)
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun rowThree(t: String, onNameChange: (String) -> Unit) {

        val propUseCase: PropUseCase =  UseCaseFactory.getPropUseCase()

        val coroutineScope = rememberCoroutineScope()

        val gitButtonsColor =  ButtonDefaults.outlinedButtonColors(backgroundColor = Color(0xFF7BB661),
                                                                   contentColor = Color(0xFFF5F5F5),
                                                                   disabledContentColor = Color(0xFF666699))

        Spacer(Modifier.width(20.dp))

        OutlinedButton( modifier = Modifier.width(200.dp),
            colors = gitButtonsColor,
            onClick = {
                        coroutineScope.launch {
                            if((::selectProp.isInitialized && !selectProp.isEmpty())  &&
                                (::selectEnv.isInitialized && !selectEnv.isEmpty())) {

                                println("if if")
                                logea("\nLaunching Query")
                                logea("\n" + selectProp + ",")
                                logea(selectEnv)
                                onNameChange("3.1.1")
                                propUseCase.findProperties(selectEnv, selectProp)
                                logea("\nGit Query working on")
                            }
                            else {
                                println("else else")
                                logea("\nNot all Fields are selected")
                            }
                            println("fin fin")
                            onNameChange("3.1.2")
                        }
                     }
        )
        {
            Text("Execute")
        }
    }

    @Composable
    private fun resultDataRow(log: String) {

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