package cl.bootcamp.calculadoramvvm.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

data class CalculatorState(
    val age: String = "",
    val weight: String = "",
    val height: String = "",
    val bmi: Double = 0.0,
    val showAlert: Boolean = false
)



