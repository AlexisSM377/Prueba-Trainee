package com.alexdevs.menu

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alexdevs.menu.databinding.ActivityEncuestaRojoBinding

class EncuestaRojo : AppCompatActivity() {

    private lateinit var binding: ActivityEncuestaRojoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityEncuestaRojoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.IbRegresar.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.submitButton.setOnClickListener {
            val answers = HashMap<String, String>()
            val questions = mapOf(
                binding.radioButtonSiDificultad to "Dificultad respiratoria severa",
                binding.radioButtonSiColoracion to "Coloración azul en piel",
                binding.radioButtonSiFrialdad to "Frialdad generalizada",
                binding.radioButtonSiTraumatismos to "Traumatismos severos múltiples",
                binding.radioButtonSiQuemaduras to "Quemaduras en todo el cuerpo",
                binding.radioButtonSiPerdida to "Pérdida de miembro u órgano",
                binding.radioButtonSiHemorragia to "Hemorragia masiva",
                binding.radioButtonSiTrabajo to "Trabajo de parte expulsivo",
                binding.radioButtonSiAbuso to "Abuso sexual"
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
                putExtra("surveyType", "Rojo")
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
        binding.radioGroupDificultad.clearCheck()
        binding.radioGroupColoracion.clearCheck()
        binding.radioGroupFrialdad.clearCheck()
        binding.radioGroupTraumatismos.clearCheck()
        binding.radioGroupQuemaduras.clearCheck()
        binding.radioGroupPerdida.clearCheck()
        binding.radioGroupHemorragia.clearCheck()
        binding.radioGroupTrabajo.clearCheck()
        binding.radioGroupAbuso.clearCheck()
    }
}
