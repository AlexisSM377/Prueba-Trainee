package com.alexdevs.menu

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alexdevs.menu.databinding.ActivityEncuestaVerdeBinding

class EncuestaVerde : AppCompatActivity() {

    private lateinit var binding: ActivityEncuestaVerdeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityEncuestaVerdeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.IbRegresar.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.submitButton.setOnClickListener {
            val answers = HashMap<String, String>()
            val questions = mapOf(
                binding.radioButtonSiFiebreM to "Fiebre mayor 38.5°c",
                binding.radioButtonSiTos to "Tos y congestión",
                binding.radioButtonSiFaringitis to "Faringitis o amigdalitis",
                binding.radioButtonSiVomito to "Vómito y diarrea sin deshidratación",
                binding.radioButtonSiDolorL to "Dolor leve",
                binding.radioButtonSiDolorH to "Dolor moderado de más de 24 horas",
                binding.radioButtonSiTraumaL to "Trauma leve",
                binding.radioButtonSiSignos to "Signos de Infección local",
                binding.radioButtonSiArdor to "Ardor al orinar",
                binding.radioButtonSiEnfermedad to "Enfermedad venérea aguda. Ansiedad y depresión",
                binding.radioButtonSiColico to "Cólico menstrual",
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
                putExtra("surveyType", "Verde")
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
        binding.radioGroupFiebreM.clearCheck()
        binding.radioGroupTos.clearCheck()
        binding.radioGroupFaringitis.clearCheck()
        binding.radioGroupVomito.clearCheck()
        binding.radioGroupDolorL.clearCheck()
        binding.radioGroupDolorH.clearCheck()
        binding.radioGroupTraumaL.clearCheck()
        binding.radioGroupSignos.clearCheck()
        binding.radioGroupArdor.clearCheck()
        binding.radioGroupEnfermedad.clearCheck()
        binding.radioGroupColico.clearCheck()
    }
}