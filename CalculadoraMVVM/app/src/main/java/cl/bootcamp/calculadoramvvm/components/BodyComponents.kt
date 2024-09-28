package cl.bootcamp.calculadoramvvm.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


//Componentes vista principal
//Recibe int retornado por funcion rangeIndicator
@Composable
fun PatientStatusColor(type:Int){
    if (type==0){
        ColorText("", Color(0xFF444B75))
    }
    if (type==1){
        ColorText("Bajo Peso", Color(0xFF444B75))
    } else if (type==2){
        ColorText("Peso Normal", Color(0xFF67973F))
    } else if (type==3){
        ColorText("Sobrepeso", Color(0xFFD5D342))
    }
    else if (type==4){
        ColorText("Obesidad Clase I", Color(0xFFCA943B))
    }
    else if (type==5){
        ColorText("Obesidad Clase II", Color(0xE8CE7B7B))
    }
    else if (type==6){
        ColorText("Obesidad Clase III", Color(0xFFC62828))
    }

}





    @Composable
    fun ColorText(
        text: String,
        color: Color

    ) {
        Text(
            modifier = Modifier
                .padding(10.dp),
            text = text,
            color = color,
            fontSize = 40.sp,
            fontWeight = FontWeight.SemiBold
        )

    }


    @Composable
    fun ButtonText(
        text: String,
        onClick: () -> Unit
    ) {
        Button(onClick = onClick) {
            Text(text = text)
        }
    }


    @Composable
    fun PatientModal(
        title: String,
        onDismissClick: () -> Unit,
        onConfirmClick: @Composable () -> Unit,
        onText: @Composable () -> Unit
    ) {
        AlertDialog(
            title = { Text(text = title) },
            shape = RoundedCornerShape(10.dp),
            onDismissRequest = onDismissClick,
            text = onText,
            confirmButton = onConfirmClick
        )
    }




    @Composable
    fun Title(text: String) {
        Text(
            text = text,
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold
        )
    }


    @Composable
    fun InputBox(
        value: String,
        onValueChange: (String) -> Unit,
        label: String
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(text = label) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp, 10.dp)

        )
    }

    @Composable
    fun CalculateButton(text: String, onClick: () -> Unit) {
        Button(
            onClick = { onClick() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp),
        )

        {
            Text(
                text = text,
                fontSize = 20.sp,
                fontWeight = FontWeight.W400,
                color = Color.DarkGray

            )
        }
    }

    @Composable
    fun MainButton(text: String, onClick: () -> Unit) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp),
        )

        {
            Text(
                text = text,
                fontSize = 20.sp,
                fontWeight = FontWeight.W400,
                color = Color.DarkGray

            )
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SegmentedButtonSelect() {
        val checkedList = remember { mutableStateListOf<Int>() }
        val options = listOf("Hombre", "Mujer")

        MultiChoiceSegmentedButtonRow {
            options.forEachIndexed { index, label ->

                SegmentedButton(
                    modifier = Modifier.width(150.dp),
                    shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                    onCheckedChange = {
                        if (checkedList.isEmpty()) {
                            checkedList.add(index)
                        } else {
                            checkedList.clear()
                            checkedList.add(index)
                        }

                    },
                    checked = index in checkedList
                ) {
                    Text(label)
                }
            }
        }
    }

    //EJERCICIO 10
    @Composable
    fun ResultText(result: Double) {
        Text(
            text = result.toString(),
            fontSize = 50.sp,
            fontWeight = FontWeight.SemiBold
        )
    }

    //EJERCICIO 12
    @Composable
    fun Alert(
        title: String,
        msj: String,
        confirmText: String,
        onDismissClick: () -> Unit,
        onConfirmClick: () -> Unit
    ) {
        AlertDialog(
            onDismissRequest = onDismissClick,
            title = { Text(text = title) },
            text = { Text(text = msj) },
            confirmButton = {
                Button(onClick = onConfirmClick) {
                    Text(text = confirmText)
                }
            }


        )
    }



