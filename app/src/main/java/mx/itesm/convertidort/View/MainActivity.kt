package mx.itesm.convertidort.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.view.View
import androidx.activity.viewModels
import mx.itesm.convertidort.Model.Convertidor
import mx.itesm.convertidort.ViewModel.ConvertidorVM
import mx.itesm.convertidort.databinding.ActivityMainBinding

//Convertidor con VMMV
class MainActivity : AppCompatActivity() {
    //Declarar una constante
    private lateinit var binding: ActivityMainBinding

    //Creando de manera indirecta un objeto
    private val convertidorVM: ConvertidorVM by viewModels()

    //Referencia al modelo, YA NO EXISTE ESTA COMUNICACIÓN
    //private val convertidor = Convertidor()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registrarBoton()

        //Suscribir a LiveData de gradosF
        registrarObservadores()
    }

    private fun registrarObservadores() {
        //Suscribir para ejecutar este codigo si hay cambios en el nnuevo valor de gradosF
        convertidorVM.gradosF.observe(this, { nuevoValor -> //Remplazamos it como iterador
            binding.etFahrenheit.setText("%.2f".format(nuevoValor))
        })
    }

    private fun registrarBoton() {
        binding.btnConvertir.setOnClickListener {
            if (binding.etCelsius.text.toString().isNotEmpty()) {
                val gradosC = binding.etCelsius.text.toString().toDouble()
                convertidorVM.convertir(gradosC)
            } else {
                //Avisar
                Toast.makeText(this, "Teclea un valor", Toast.LENGTH_SHORT).show()
                binding.etCelsius.
                error = "Error!!!"
            }
        }
    }
}