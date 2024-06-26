package com.alexdevs.menu

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alexdevs.menu.databinding.ActivityEncuestaAmarillaBinding

class EncuestaAmarilla : AppCompatActivity() {

    private lateinit var binding: ActivityEncuestaAmarillaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEncuestaAmarillaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.IbRegresar.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.submitButton.setOnClickListener {
            val answers = HashMap<String, String>()
            val questions = mapOf(
                binding.radioButtonSiFiebre to "Fiebre mayor 38.5°C",
                binding.radioButtonSiVertigo to "Vértigo severo",
                binding.radioButtonSiDificultadR to "Dificultad respiratoria leve",
                binding.radioButtonSiVomito to "Vómito y diarrea con deshidratacion",
                binding.radioButtonSiSintomas to "Síntomas asociadas o diálisis",
                binding.radioButtonSiDolorM to "Dolor moderado de menos de 24 horas",
                binding.radioButtonSiTraumaM to "Trauma moderado",
                binding.radioButtonSiQuemaduraG to "Quemadura ll o l grado",
                binding.radioButtonSiSangradoM to "Sangrado moderado",
                binding.radioButtonSiReaccion to "Reacción alérgica con brote generalizado",
                binding.radioButtonSiEvento to "Todo Evento en Salud Pública que consulte",
            )

            var hasYes = false
            var hasNo = false

            for ((id, question) in questions){
                val radioButton: RadioButton = findViewById(id.id)
                val answer = if (radioButton.isChecked) "Sí" else "No"
                answers[question] = answer
                if (answer == "Sí") hasYes = true
                if (answer == "No") hasNo = true
            }

            val intent = Intent(this, Resultados::class.java).apply {
                putExtra("answers", answers)
                putExtra("needsAttention", hasYes)
                putExtra("surveyType", "Amarilla")
            }
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onResume() {
        super.onResume()
        clearForm()
    }

    private fun clearForm() {
        binding.radioGroupFiebre.clearCheck()
        binding.radioGroupVertigo.clearCheck()
        binding.radioGroupDificultadR.clearCheck()
        binding.radioGroupVomito.clearCheck()
        binding.radioGroupSintomas.clearCheck()
        binding.radioGroupDolorM.clearCheck()
        binding.radioGroupTraumaM.clearCheck()
        binding.radioGroupQuemaduraG.clearCheck()
        binding.radioGroupSangradoM.clearCheck()
        binding.radioGroupReaccion.clearCheck()
        binding.radioGroupEvento.clearCheck()
    }
}