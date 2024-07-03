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
                Pair(R.id.radioButtonSiDificultad, R.id.radioButtonNoDificultad) to "Dificultad respiratoria severa",
                Pair(R.id.radioButtonSiColoracion, R.id.radioButtonNoColoracion) to "Coloración azul en piel",
                Pair(R.id.radioButtonSiFrialdad, R.id.radioButtonNoFrialdad) to "Frialdad generalizada",
                Pair(R.id.radioButtonSiTraumatismos, R.id.radioButtonNoTraumatismos) to "Traumatismos severos múltiples",
                Pair(R.id.radioButtonSiQuemaduras, R.id.radioButtonNoQuemaduras) to "Quemaduras en todo el cuerpo",
                Pair(R.id.radioButtonSiPerdida, R.id.radioButtonNoPerdida) to "Pérdida de miembro u órgano",
                Pair(R.id.radioButtonSiHemorragia, R.id.radioButtonNoHemorragia) to "Hemorragia masiva",
                Pair(R.id.radioButtonSiTrabajo, R.id.radioButtonNoTrabajo) to "Trabajo de parte expulsivo",
                Pair(R.id.radioButtonSiAbuso, R.id.radioButtonNoAbuso) to "Abuso sexual",

            )



            for ((ids, question) in questions) {
                val (idYes, idNo) = ids
                val radioButtonYes: RadioButton = findViewById(idYes)
                val radioButtonNo: RadioButton = findViewById(idNo)
                val answer = if (radioButtonYes.isChecked) "Sí" else "No"
                answers[question] = answer
            }


            val intent = Intent(this, Resultados::class.java).apply {
                putExtra("answers", answers)
                putExtra("surveyType", "Roja")
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
