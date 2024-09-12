package cl.bootcamp.calculadoramvvm.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cl.bootcamp.calculadoramvvm.components.Alert
import cl.bootcamp.calculadoramvvm.components.InputBox
import cl.bootcamp.calculadoramvvm.components.MainButton
import cl.bootcamp.calculadoramvvm.components.ResultText
import cl.bootcamp.calculadoramvvm.components.SegmentedButtonSelect
import cl.bootcamp.calculadoramvvm.components.Title
import cl.bootcamp.calculadoramvvm.viewModels.CalculatorViewModel

@Composable
fun CalculatorScreen(viewModel: CalculatorViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement= Arrangement.Center,
        horizontalAlignment= Alignment.CenterHorizontally,
    )
    {
        //SIN MODEL
//        var age by remember { mutableStateOf("") }
//        var weight by remember { mutableStateOf("") }
//        var height by remember { mutableStateOf("") }
//        var bmi by remember { mutableStateOf(0.0) }

         val state = viewModel.state

        Title(text = "Calculadora de IMC")
        SegmentedButtonSelect()
        InputBox(state.age,onValueChange ={viewModel.onValue(it,"age")}, "Edad")
        InputBox(state.weight,onValueChange ={viewModel.onValue(it,"weight")}, "Peso (Kg)")
        InputBox(value = state.height, onValueChange = {viewModel.onValue(it,"height")}, label ="Altura (cm)")

        MainButton(){
            viewModel.calculate()
           //SIN MODEL bmi = viewModel.calculate(age, weight, height)

        }
        ResultText(state.bmi)
        if (state.showAlert){
            Alert(
                title ="Error" ,
                msj ="Debe ingresar todos los campos",
                confirmText ="Aceptar" ,
                onConfirmClick = { viewModel.calcelAlert()}
            ) {

            }
        }


    }

}
