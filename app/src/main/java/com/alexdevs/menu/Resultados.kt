package com.alexdevs.menu

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.alexdevs.menu.databinding.ActivityResultadosBinding

class Resultados : AppCompatActivity() {

    private lateinit var binding: ActivityResultadosBinding
    private lateinit var answers: HashMap<String, String>
    private var surveyType: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.IbRegresar.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // Recibir los datos de la encuesta
        val respuestas = intent.getSerializableExtra("respuestas") as HashMap<String, String>?

        // Calcular el nivel de atención y la atención necesaria
        val respuestasSi = contarRespuestasSi(respuestas)
        val nivelAtencion = calcularNivelAtencion(respuestasSi)
        val textoAtencion = obtenerTextoAtencion(nivelAtencion)

        // Mostrar los resultados en los TextView
        findViewById<TextView>(R.id.nivelAtencion).text = "$nivelAtencion"
        findViewById<TextView>(R.id.porcentajeAtencion).text = "$textoAtencion"

        // Mostrar las respuestas (puedes ajustar este método según tu estructura de datos)
        val resultadosTextView = findViewById<TextView>(R.id.resultsTextView)
        resultadosTextView.text = obtenerRespuestasFormateadas(respuestas)
    }

    private fun contarRespuestasSi(respuestas: HashMap<String, String>?): Int {
        var contadorSi = 0
        respuestas?.values?.forEach {
            if (it.equals("Sí", ignoreCase = true)) {
                contadorSi++
            }
        }
        return contadorSi
    }

    private fun calcularNivelAtencion(respuestasSi: Int): String {
        return when {
            respuestasSi <= 12 -> "Nivel 1: 🔴"
            respuestasSi <= 24 -> "Nivel 2: 🟠"
            respuestasSi <= 36 -> "Nivel 3: 🟡"
            respuestasSi <= 48 -> "Nivel 4: 🟢"
            else -> "Nivel 5: 🔵"
        }
    }

    private fun obtenerTextoAtencion(nivelAtencion: String): String {
        return when (nivelAtencion) {
            "Nivel 1: 🔴" -> "Atención: Inmediata"
            "Nivel 2: 🟠" -> "Atención: Dentro de los siguientes 30 minutos"
            "Nivel 3: 🟡" -> "Atención: Los siguientes 120 minutos"
            "Nivel 4: 🟢" -> "Atención: 180 minutos"
            "Nivel 5: 🔵" -> "Atención: Por Consulta Externa"
            else -> "Atención: Sin definir"
        }
    }

    private fun obtenerRespuestasFormateadas(respuestas: HashMap<String, String>?): String {
        val sb = StringBuilder()
        respuestas?.forEach { (pregunta, respuesta) ->
            sb.append("$pregunta: $respuesta\n")
        }
        return sb.toString()
    }
}
