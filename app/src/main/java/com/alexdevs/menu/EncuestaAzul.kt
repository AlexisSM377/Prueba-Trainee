package com.alexdevs.menu

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alexdevs.menu.databinding.ActivityEncuestaAzulBinding

class EncuestaAzul : AppCompatActivity() {

    private lateinit var binding: ActivityEncuestaAzulBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityEncuestaAzulBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.IbRegresar.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.submitButton.setOnClickListener {
            val answers = HashMap<String, String>()
            val questions = mapOf(
                binding.radioButtonSiSintomas to "Sintomas agudas que no comprometan el estado general",
                binding.radioButtonSiDolorC to "Dolor de cabeza crónico",
                binding.radioButtonSiTosC to "Tos crónica",
                binding.radioButtonSiInapetencia to "Inapetencia",
                binding.radioButtonSiDiarrea to "Diarrea crónica. Estreñimiento",
                binding.radioButtonSiDolorAC to "Dolor abdominal crónico",
                binding.radioButtonSiDolorP to "Dolor postraumático leve",
                binding.radioButtonSiDermatitis to "Dermatitis",
                binding.radioButtonSiEstres to "Estrés emocional",
                binding.radioButtonSiEnfermedadC to "Enfermedades crónicas",
                binding.radioButtonSiFormulacion to "Formulación de medicamentos",
                binding.radioButtonSiLectura to "Lectura de exámenes",
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
                putExtra("surveyType", "Azul")
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
        binding.radioGroupSintomas.clearCheck()
        binding.radioGroupDolorC.clearCheck()
        binding.radioGroupTosC.clearCheck()
        binding.radioGroupInapetencia.clearCheck()
        binding.radioGroupDiarrea.clearCheck()
        binding.radioGroupDolorAC.clearCheck()
        binding.radioGroupDolorP.clearCheck()
        binding.radioGroupDermatitis.clearCheck()
        binding.radioGroupEstres.clearCheck()
        binding.radioGroupEnfermedadC.clearCheck()
        binding.radioGroupFormulacion.clearCheck()
        binding.radioGroupLectura.clearCheck()
    }
}