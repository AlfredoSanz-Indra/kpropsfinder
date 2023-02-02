package es.kprops.view

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.unit.dp
import es.kprops.core.resources.TheResources
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text

/**
 * @author Alfredo Sanz
 * @time 2023
 */
class EnvironmentchecksView {

    var log: String = "Init Environmentchecks View"

    lateinit var selectEnv: String

    private fun setEnvironment(t: String) {
        this.selectEnv = t
    }

    private fun logea(t: String) {
        this.log += t
    }

    @Preview
    @Composable
    fun createView() {

        var resultProp by rememberSaveable { mutableStateOf("Init") }

        MaterialTheme(colors = darkColors(background = Color.Black)) {
            Column(
                Modifier.background(color = Color.White)
                        .width(800.dp),
                Arrangement.Top,
                Alignment.Start
            ) {
                //TITULO
                Row(
                    Modifier.background(color = Color.White)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    rowZero()
                }

                Spacer(Modifier.height(20.dp))

                //ENVIRONMENT
                Row(
                    Modifier.background(color = Color.White)
                        .width(800.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    rowEnvironment()
                }

                Spacer(Modifier.height(20.dp))

                //Clips
                Row(
                    Modifier.background(color = Color.White)
                            .width(800.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    rowChecks()
                }
            }
        }
    }

    @Composable
    private fun rowZero() {

        Spacer(Modifier.width(20.dp).height(20.dp))

        Text(
            text = "Environment wealth check out",
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.onSecondary,
        )
    }

    /**
     * RadioButtons
     */
    @Composable
    private fun rowEnvironment() {

        Spacer(Modifier.width(20.dp).height(20.dp))

        val radioOptions = TheResources.getConstantsProp().getProperty("ENVIRONMENT_NAME_LIST")
            .split(",")
            .map { it.trim() }
        val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }

        setEnvironment(selectedOption) //Default value

        Column(Modifier.selectableGroup()) {
            Row(
                Modifier.background(color = Color.White)
                        .fillMaxWidth(),
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

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun rowChecks() {

        Box(
            modifier = Modifier.padding(15.dp)
                               .border(1.dp, color = Color.Gray, shape = RoundedCornerShape(16.dp))
                               .fillMaxWidth()
                               .height(50.dp)
                               .padding(15.dp)
        ) {
            Column(Modifier.selectableGroup()) {
                Row(
                    modifier = Modifier.background(color = Color.White)
                                       .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    var x = 1
                    for (item in TheResources.getChecksenvironment().clips) {
                        AssistChip(
                            onClick = { println("$item.label has been pressed") },
                            label = { Text(item.label) },
                            //modifier = Modifier.padding(10.dp),
                            leadingIcon = {
                                Icon(
                                    if(x==1) Icons.Filled.Settings else  Icons.Filled.Add,
                                    contentDescription = "Super todos",
                                    Modifier.size(AssistChipDefaults.IconSize)
                                )
                            }
                        )//Chips
                        x = if(x == 1) 2 else 1
                    }//for
                }//row
            }//Column
        }//Box
    }//end
}