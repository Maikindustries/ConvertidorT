package mx.itesm.convertidort.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.convertidort.Model.Convertidor

//ViewModel
class ConvertidorVM: ViewModel() {

    //Unir el modelo
    val convertidor = Convertidor()

    //Variables que representan el estado de la app
    //Datos que comunica entre Model y View
    val gradosF = MutableLiveData<Double>()

    //Funciones para cambiar el estado
    fun convertir(gradosC: Double) {
        gradosF.value = convertidor.convertir(gradosC)   //Llamar al modelo
    }
}