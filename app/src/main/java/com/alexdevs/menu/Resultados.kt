package com.alexdevs.menu

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.alexdevs.menu.databinding.ActivityResultadosBinding
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class Resultados : AppCompatActivity() {

    private lateinit var binding: ActivityResultadosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityResultadosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.IbRegresar.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val answers = intent.getSerializableExtra("answers") as HashMap<String, String>
        val surveyType = intent.getStringExtra("surveyType")
        val needsAttention = intent.getBooleanExtra("needsAttention", false)

        val nivelAtencion: TextView = binding.nivelAtencion
        val porcentajeAtencion: TextView = binding.porcentajeAtencion
        val resultsTextView: TextView = binding.resultsTextView

        val resultsText = StringBuilder()
        for ((question, answer) in answers) {
            resultsText.append("$question: $answer\n")
        }
        resultsTextView.text = resultsText.toString()

        when {
            answers.values.all { it == "No" } -> {
                nivelAtencion.text = when (surveyType) {
                    "Rojo" -> "Nivel 1: 🔴"
                    "Naranja" -> "Nivel 2: 🟠"
                    "Amarilla" -> "Nivel 3: 🟡"
                    "Verde" -> "Nivel 4: 🟢"
                    "Azul" -> "Nivel 5: 🔵"
                    else -> "Nivel desconocido"
                }
                porcentajeAtencion.text = "El usuario no requiere atención inmediata."
            }
            needsAttention -> {
                when (surveyType) {
                    "Rojo" -> {
                        nivelAtencion.text = "Nivel 1: 🔴"
                        porcentajeAtencion.text = "ATENCIÓN: Inmediata"
                    }
                    "Naranja" -> {
                        nivelAtencion.text = "Nivel 2: 🟠"
                        porcentajeAtencion.text = "ATENCIÓN: Dentro de los siguientes 30 minutos"
                    }
                    "Amarilla" -> {
                        nivelAtencion.text = "Nivel 3: 🟡"
                        porcentajeAtencion.text = "ATENCIÓN: Los siguientes 120 minutos"
                    }
                    "Verde" -> {
                        nivelAtencion.text = "Nivel 4: 🟢"
                        porcentajeAtencion.text = "ATENCIÓN: 180 minutos"
                    }
                    "Azul" -> {
                        nivelAtencion.text = "Nivel 5: 🔵"
                        porcentajeAtencion.text = "ATENCIÓN: Por Consulta Externa"
                    }
                }
            }
            else -> {
                nivelAtencion.text = when (surveyType) {
                    "Rojo" -> "Nivel 1: 🔴"
                    "Naranja" -> "Nivel 2: 🟠"
                    "Amarilla" -> "Nivel 3: 🟡"
                    "Verde" -> "Nivel 4: 🟢"
                    "Azul" -> "Nivel 5: 🔵"
                    else -> "Nivel desconocido"
                }
                porcentajeAtencion.text = "El usuario requiere una evaluación adicional."
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
