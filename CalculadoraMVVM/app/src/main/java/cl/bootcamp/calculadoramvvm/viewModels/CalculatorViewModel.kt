package cl.bootcamp.calculadoramvvm.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cl.bootcamp.calculadoramvvm.models.CalculatorState

class CalculatorViewModel: ViewModel() {

    var state by mutableStateOf(CalculatorState())
    private set


    //Agregamos On value
    fun onValue(value: String, field: String) {
        when (field) {
            "age" -> state = state.copy(age = value)
            "weight" -> state = state.copy(weight = value)
            "height" -> state = state.copy(height = value)
        }
    }

    //Version con Model
    fun calculate(){
        val age= state.age
        val weight= state.weight
        val height= state.height
        if ( age != ""  && weight != "" && height != ""){
            state=state.copy(
                bmi = calculateBMI(weight.toDouble(), height.toDouble())
            )
        }
        else{
            state=state.copy(
                showAlert = true
            )
        }
    }


    fun calcelAlert() {
        state = state.copy(
            showAlert = false
        )
    }



    // LLevamos esta funcion de BodyComponents a CalculatorViewModel
    fun calculateBMI(weight: Double, height: Double): Double {
        val imc = weight / (height / 100 * height / 100)
        return kotlin.math.round(imc * 10) / 10.0
    }

}

//LLevamos logica del boton a CalculatorView con la funcion nueva calculate
// Version sin modal(Ejercicio 11)
//VERSION SIN MODEL

//    fun calculate(age: String, weight: String, height: String):Double {
//
//    if (age != "" && weight != "" && height != "") {
//        val bmi = calculateBMI(weight.toDouble(), height.toDouble())
//        return bmi
//    }
//    else{
//        return 0.0
//    }
// }


