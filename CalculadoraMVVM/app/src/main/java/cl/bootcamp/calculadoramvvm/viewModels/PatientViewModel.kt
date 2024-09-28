package cl.bootcamp.calculadoramvvm.viewModels


import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import cl.bootcamp.calculadoramvvm.models.Patient


class PatientViewModel: ViewModel() {




    //PRUEBA 2
    private val _listaPacientes =  mutableStateListOf<Patient>()
    val listaPacientes: List<Patient> = _listaPacientes

    private var index=0
    fun agregarPaciente(nombre: String) {
       val nuevoPaciente=Patient(id=index++,name=nombre)
        _listaPacientes.add(nuevoPaciente)
    }


        fun editarPacienteporId( id: Int,edad:String,imc:Double,evaluacion:Int) {
            if (id in _listaPacientes.indices) {
                _listaPacientes[id].apply {
                    isEdited
                    age = edad
                    bmi = imc
                    evaluation = evaluacion
                }
            }
                else {
                    println("No se encontro el paciente")
                }
            }



    // LLevamos esta funcion de BodyComponents a CalculatorViewModel
    fun calculateBMI(weight: Double, height: Double): Double {
        val imc = weight / (height / 100 * height / 100)
        return kotlin.math.round(imc * 10) / 10.0
    }


    //Funcion que devuelve int usado en el composable

    fun rangeIndicator(bmi: Double): Int {
        if (bmi == 0.0) {
            return 0
        }
        if (bmi in 0.1..18.5) {
            return 1
        }
        if (bmi in 18.5..24.9) {
            return 2
        }
        if (bmi in 25.0..29.9) {
            return 3
        }

        if (bmi in 30.0..34.9) {
            return 4
        }
        if (bmi in 35.0..39.9) {
            return 5
        } else
            return 6

    }


    fun patientEvaluation(type:Int):String {
        if (type == 0) {
            return "Sin Datos"
        }
        if (type == 1) {
            return "Bajo Peso"
        }
        if (type == 2) {
            return "Peso Normal"
        }
        if (type == 3) {
            return "Sobrepeso"
        }
        if (type == 4) {
            return "Obesidad Clase I"
        }
        if (type == 5) {
            return "Obesidad Clase II"
        }
        else
        {
            return "Obesidad Clase III"
        }
    }

}







