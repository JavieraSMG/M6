package cl.bootcamp.calculadoramvvm

import MainView
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cl.bootcamp.calculadoramvvm.navigation.NavManager
import cl.bootcamp.calculadoramvvm.ui.theme.CalculadoraMVVMTheme
import cl.bootcamp.calculadoramvvm.viewModels.PatientViewModel
import cl.bootcamp.calculadoramvvm.views.CalculatorScreen
import cl.bootcamp.calculadoramvvm.viewsOnBoarding.MainOnBoarding


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraMVVMTheme {

                NavManager(PatientViewModel())
            }
            }
        }
    }


