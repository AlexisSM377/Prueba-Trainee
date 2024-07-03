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

        answers = intent.getSerializableExtra("answers") as HashMap<String, String>
        surveyType = intent.getStringExtra("surveyType")

        // Mostrar respuestas inicialmente
        displayAnswers(answers)

        binding.BtnEvaluar.setOnClickListener {
            evaluateAndDisplayResults()
        }
    }

    private fun displayAnswers(answers: HashMap<String, String>) {
        val resultsTextView: TextView = findViewById(R.id.resultsTextView)
        val resultsText = answers.entries.joinToString("\n") { (question, answer) ->
            "$question: $answer"
        }
        resultsTextView.text = resultsText
    }

    private fun evaluateAndDisplayResults() {
        val nivelAtencion: TextView = findViewById(R.id.nivelAtencion)
        val porcentajeAtencion: TextView = findViewById(R.id.porcentajeAtencion)
        val porcentajeAtencionTexto: TextView = findViewById(R.id.porcentajeFinal)

        val yesCount = answers.values.count { it == "Sí" }
        val noCount = answers.values.count { it == "No" }

        when {
            yesCount == answers.size -> {
                porcentajeAtencion.text = "El usuario necesita atención inmediata: 100%"
                porcentajeAtencionTexto.text = "100%"
                porcentajeAtencionTexto.visibility = TextView.VISIBLE
                when (surveyType) {
                    "Roja" -> nivelAtencion.text = "Nivel 1: 🔴"
                    "Naranja" -> nivelAtencion.text = "Nivel 2: 🟠"
                    "Amarilla" -> nivelAtencion.text = "Nivel 3: 🟡"
                    "Verde" -> nivelAtencion.text = "Nivel 4: 🟢"
                    "Azul" -> nivelAtencion.text = "Nivel 5: 🔵"
                }
            }
            noCount == answers.size -> {
                porcentajeAtencion.text = "El usuario no requiere atención inmediata."
                porcentajeAtencionTexto.visibility = TextView.GONE
                when (surveyType) {
                    "Roja" -> nivelAtencion.text = "Nivel 1: 🔴"
                    "Naranja" -> nivelAtencion.text = "Nivel 2: 🟠"
                    "Amarilla" -> nivelAtencion.text = "Nivel 3: 🟡"
                    "Verde" -> nivelAtencion.text = "Nivel 4: 🟢"
                    "Azul" -> nivelAtencion.text = "Nivel 5: 🔵"
                }
            }
            else -> {
                porcentajeAtencion.text = "El usuario necesita atención: 50%"
                porcentajeAtencionTexto.text = "50%"
                porcentajeAtencionTexto.visibility = TextView.VISIBLE
                when (surveyType) {
                    "Roja" -> nivelAtencion.text = "Nivel 1: 🔴"
                    "Naranja" -> nivelAtencion.text = "Nivel 2: 🟠"
                    "Amarilla" -> nivelAtencion.text = "Nivel 3: 🟡"
                    "Verde" -> nivelAtencion.text = "Nivel 4: 🟢"
                    "Azul" -> nivelAtencion.text = "Nivel 5: 🔵"
                }
            }
        }
    }
}
