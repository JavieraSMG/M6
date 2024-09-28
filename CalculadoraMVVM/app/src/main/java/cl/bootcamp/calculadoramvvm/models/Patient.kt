package cl.bootcamp.calculadoramvvm.models

data class Patient(

    var id: Int = 0,
    var name: String = "",
    var age: String = "",
    var weight: String = "",
    var height: String = "",
    var bmi: Double = 0.0,
    var evaluation:Int=0,
    var isEdited:Boolean=false




)



