package es.kprops.view

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import es.kprops.core.di.UseCaseFactory
import es.kprops.core.resources.TheResources
import es.kprops.domain.api.propcases.PropUseCase
import es.kprops.domain.model.prop.PropResult
import es.kprops.domain.model.prop.Property
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @author Alfredo Sanz
 * @time 2022
 */
class PropertiesView {

    var log: String = "Init Properties View"

    lateinit var selectEnv: String

    private fun logea(t: String) {
        this.log += t
    }

    private fun setEnvironment(t: String) {
        this.selectEnv = t
    }

    @Preview
    @Composable
    fun createView() {

        //var resultProp by rememberSaveable { mutableStateOf("Init") }
        var searchPropertyName by rememberSaveable { mutableStateOf("")  }
        var searchPropertyValue by rememberSaveable { mutableStateOf("")  }

        val resultValues:  List<Property> = ArrayList()
        var resultBut by rememberSaveable { mutableStateOf(resultValues) }

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
                    rowSearchTexts( onNameChange = { searchPropertyName = it }, onValueChange = { searchPropertyValue = it })
                }

                Spacer(Modifier.height(20.dp))

                //ENVIRONMENT
                Row(
                    Modifier.background(color = Color.White)
                            .width(800.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    rowEnv()
                }

                Spacer(Modifier.height(20.dp))

                //BUTTON
                Row(
                    Modifier.background(color = Color.White)
                            .width(800.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    rowButtons(onValueChange = { resultBut = it }, searchPropertyName, searchPropertyValue, resultBut)
                }

                //LOG
                Row(Modifier.background(color = Color.White).width(800.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Top
                ) {
                    resultDataRow(resultBut)
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

    /**
     * Textfield
     */
    @Composable
    private fun rowSearchTexts(onNameChange: (String) -> Unit, onValueChange: (String) -> Unit) {

        Spacer(Modifier.width(20.dp).height(20.dp))

        val maxLength = 30
        var txSearchName by rememberSaveable { mutableStateOf(TextFieldValue("", TextRange(0, 7))) }
        var txSearchValue by rememberSaveable { mutableStateOf(TextFieldValue("", TextRange(0, 7))) }

        Column(Modifier.selectableGroup()) {
            Row(
                Modifier.background(color = Color.White)
                        .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                OutlinedTextField(
                    value = txSearchName,
                    modifier = Modifier.width(600.dp),
                    onValueChange = {
                                     if (it.text.length <= maxLength) {
                                         txSearchName = it
                                         onNameChange(txSearchName.text)
                                     }
                                    },
                    label = { Text("Property name") },
                    shape = MaterialTheme.shapes.small,
                    placeholder = { Text(text = "*Property name") },
                    singleLine = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = Color(0xFF7BB661),
                                                                       placeholderColor = Color(0xFF7BB661),
                                                                       focusedLabelColor =  Color(0xFF7BB661),
                                                                       unfocusedLabelColor = Gray,
                                                                       unfocusedBorderColor = Color.LightGray,
                                                                       disabledPlaceholderColor = Color.LightGray,
                                                                       textColor = Color.Black,
                                                                       disabledTextColor = Gray
                                                                       )
            )}

            Spacer(Modifier.height(20.dp))

            Row(
                Modifier.background(color = Color.White)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                OutlinedTextField(
                    value = txSearchValue,
                    modifier = Modifier.width(600.dp),
                    onValueChange = {
                        if (it.text.length <= maxLength) {
                            txSearchValue = it
                            onValueChange(txSearchValue.text)
                        }
                    },
                    label = { Text("Property value") },
                    shape = MaterialTheme.shapes.small,
                    placeholder = { Text(text = "*Property value") },
                    singleLine = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = Color(0xFF7BB661),
                        placeholderColor = Color(0xFF7BB661),
                        focusedLabelColor =  Color(0xFF7BB661),
                        unfocusedLabelColor = Gray,
                        unfocusedBorderColor = Color.LightGray,
                        disabledPlaceholderColor = Color.LightGray,
                        textColor = Color.Black,
                        disabledTextColor = Gray
                    )
                )
            }//Row
        }//Column
    }

    /**
     * RadioButtons
     */
    @Composable
    private fun rowEnv() {

        Spacer(Modifier.width(20.dp).height(20.dp))

        val radioOptions = TheResources.getConstantsProp().getProperty("ENVIRONMENT_NAME_LIST")
                                .split(",")
                                .map { it.trim() }
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
                        Modifier.height(30.dp)
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
                                                                    unselectedColor = Gray,
                                                                    disabledColor = Gray
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

    /**
     * Button
     */
    @Composable
    private fun rowButtons(onValueChange: (List<Property>) -> Unit, searchPropertyName: String, searchPropertyValue: String, resultValues: List<Property>) {

        val gitButtonsColor =  ButtonDefaults.outlinedButtonColors(backgroundColor = Color(0xFF7BB661),
                                                                   contentColor = Color(0xFFF5F5F5),
                                                                   disabledContentColor = Color(0xFF666699))

        Spacer(Modifier.width(20.dp))

        val coroutineScope = rememberCoroutineScope()
        val emptyList: List<Property> = ArrayList()
        val nValues: String = resultValues.size.toString()
        var buttonPressed by rememberSaveable { mutableStateOf(false) }

        Row {
            OutlinedButton(modifier = Modifier.width(200.dp),
                colors = gitButtonsColor,
                onClick = {
                    if (::selectEnv.isInitialized && !selectEnv.isEmpty()) {
                        if (!searchPropertyName.isNullOrEmpty() && !searchPropertyName.isNullOrBlank()) {
                            logea("\nPerforming search by Name . property n: $searchPropertyName, env: $selectEnv ")
                            searchPropertyByName(coroutineScope, onValueChange, searchPropertyName, onButtonPressed = { buttonPressed = it })
                        } else if (!searchPropertyValue.isNullOrEmpty() && !searchPropertyValue.isNullOrBlank()) {
                            logea("\nPerforming search by Value . property v: $searchPropertyValue, env: $selectEnv ")
                            searchPropertyByValue(coroutineScope, onValueChange, searchPropertyValue, onButtonPressed = { buttonPressed = it })
                        }
                        onValueChange(emptyList)
                    } else {
                        onValueChange(emptyList)
                        logea("\nresult 406 . Missing required fields")
                        println("result 406 . Missing required fields")
                        onValueChange(emptyList)
                    }
                }
            )
            {
                Text("Search")
            }

            Spacer(Modifier.width(20.dp))

            Text(text = "Properties Found ($nValues)",
                 Modifier.padding(vertical = 18.dp),
                 style = MaterialTheme.typography.body1,
                 color = MaterialTheme.colors.onPrimary
            )

            if(buttonPressed) {
                Spacer(Modifier.width(20.dp))

                CircularProgressIndicator()
            }
        }//row
    }


    private fun searchPropertyByName(coroutineScope: CoroutineScope,
                                     onValueChange: (List<Property>) -> Unit,
                                     _searchPropertyName: String,
                                     onButtonPressed: (Boolean) -> Unit) {

        val propUseCase: PropUseCase =  UseCaseFactory.getPropUseCase()

        var  r: PropResult
        coroutineScope.launch(Dispatchers.IO) {
            onButtonPressed(true)
            r = propUseCase.findProperties(selectEnv, _searchPropertyName)

            var resultTrace = "\nPropertiesView->searchPropertyByName - result . status: ${r.status}, elements: ${r.propList.size} "
            if(300 <= r.status) {
                resultTrace += ", error: ${r.errorMessage}"
                val errP = Property()
                errP.id = 1
                errP.key = "Error"
                errP.value = resultTrace
                val errPList: MutableList<Property> = ArrayList()
                errPList.add(errP)
                r = PropResult(errPList, r.status)
            }
            println(resultTrace)
            onValueChange(r.propList)
            onButtonPressed(false)
        }
    }

    private fun searchPropertyByValue(coroutineScope: CoroutineScope,
                                      onValueChange: (List<Property>) -> Unit,
                                      _searchPropertyValue: String,
                                      onButtonPressed: (Boolean) -> Unit) {

        val propUseCase: PropUseCase =  UseCaseFactory.getPropUseCase()

        var  r: PropResult
        coroutineScope.launch(Dispatchers.IO) {
            onButtonPressed(true)
            r = propUseCase.findPropertiesByValue(selectEnv, _searchPropertyValue)

            var resultTrace = "\nPropertiesView->searchPropertyByValue - result . status: ${r.status}, elements: ${r.propList.size} "
            if(300 <= r.status) {
                resultTrace += ", error: ${r.errorMessage}"
                val errP = Property()
                errP.id = 1
                errP.key = "Error"
                errP.value = resultTrace
                val errPList: MutableList<Property> = ArrayList()
                errPList.add(errP)
                r = PropResult(errPList, r.status)
            }
            println(resultTrace)
            onValueChange(r.propList)
            onButtonPressed(false)
        }
    }

    @Composable
    private fun resultDataRow(resultValues: List<Property>) {

        Column(
            Modifier.padding(4.dp)
                    .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier.padding(15.dp)
                                   .border(2.dp, color = Gray, shape = RoundedCornerShape(16.dp))
                                   .fillMaxWidth()
                                   .height(350.dp)
                                   .padding(15.dp)
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxHeight()
                                       .padding(horizontal = 10.dp)
                ) {
                    items(resultValues.size, itemContent = { item ->
                        val elem = resultValues.get(item)

                        Card(
                            modifier = Modifier.padding(vertical = 5.dp)
                                               .fillMaxWidth()
                                               .wrapContentHeight(),
                            shape = MaterialTheme.shapes.medium,
                            elevation = 5.dp,
                            backgroundColor = MaterialTheme.colors.secondary
                        )
                        {
                            Column {
                                Row {
                                    Column(
                                        Modifier.padding(4.dp)
                                                .width(550.dp),
                                        horizontalAlignment = Alignment.Start
                                    ) {
                                        Text(
                                            text = elem.key,
                                            style = MaterialTheme.typography.h6,
                                            color = MaterialTheme.colors.onSecondary,
                                        )
                                    }
                                    Column(
                                        Modifier.padding(4.dp)
                                                .fillMaxWidth(),
                                        horizontalAlignment = Alignment.End
                                    ) {
                                        Text(
                                            text = elem.domain,
                                            style = MaterialTheme.typography.caption,
                                            color = MaterialTheme.colors.onPrimary
                                        )
                                    }
                                }//Row

                                Row {
                                    Column(
                                        Modifier.padding(8.dp)
                                                .fillMaxWidth()
                                    ) {
                                        Text(
                                            text = elem.value,
                                            style = MaterialTheme.typography.subtitle1,
                                            color = MaterialTheme.colors.onSecondary,
                                        )

                                        Spacer(Modifier.height(8.dp))

                                        Text(
                                            text = elem.ds_descripcion_interna,
                                            style = MaterialTheme.typography.caption,
                                            color = MaterialTheme.colors.onSecondary,
                                        )
                                    }
                                }//Row
                            }//Column
                        }//card
                    })//items
                }//lazyColumn
            }//Box
        }//Column
    }
}