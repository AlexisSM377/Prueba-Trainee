package com.alexdevs.menu

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alexdevs.menu.databinding.ActivityEncuestaNaranjaBinding

class EncuestaNaranja : AppCompatActivity() {

    private lateinit var binding: ActivityEncuestaNaranjaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityEncuestaNaranjaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.IbRegresar.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.submitButton.setOnClickListener {
            val answers = HashMap<String, String>()
            val questions = mapOf(
                binding.radioButtonSiAlteracion to "Alteración aguda de signos vitales",
                binding.radioButtonSiEstado to "Estado convulsivo",
                binding.radioButtonSiDeficiencia to "Deficiencia respiratoria moderada",
                binding.radioButtonSiCrisis to "Crisis hipertensiva",
                binding.radioButtonSiDiabetes to "Diabetes descompensada",
                binding.radioButtonSiDolor to "Dolor torácico",
                binding.radioButtonSiTrauma to "Trauma severo",
                binding.radioButtonSiQuemadura to "Quemadura de III grado",
                binding.radioButtonSiRiesgo to "Riesgo de pérdida de miembro u órgano",
                binding.radioButtonSiFractura to "Fractura",
                binding.radioButtonSiDigestivo to "Hemorragia digestiva",
                binding.radioButtonSiSangrado to "Sangrado vaginal en embarazadas",
                binding.radioButtonSiTrabajoP to "Trabajo de parto",
                binding.radioButtonSiAbusoS to "Abuso sexual antiguo",
                binding.radioButtonSiAgitacion to "Agitación psicomotora",
                binding.radioButtonSiIngestion to "Ingestión de sustancias toxicas o envenenamiento",
                binding.radioButtonSiDolorA to "Dolor agudo",
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
                putExtra("surveyType", "Naranja")
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
        binding.radioGroupAlteracion.clearCheck()
        binding.radioGroupEstado.clearCheck()
        binding.radioGroupDeficiencia.clearCheck()
        binding.radioGroupCrisis.clearCheck()
        binding.radioGroupDiabetes.clearCheck()
        binding.radioGroupDolor.clearCheck()
        binding.radioGroupTrauma.clearCheck()
        binding.radioGroupQuemadura.clearCheck()
        binding.radioGroupRiesgo.clearCheck()
        binding.radioGroupFractura.clearCheck()
        binding.radioGroupDigestivo.clearCheck()
        binding.radioGroupSangrado.clearCheck()
        binding.radioGroupTrabajoP.clearCheck()
        binding.radioGroupAbusoS.clearCheck()
        binding.radioGroupAgitacion.clearCheck()
        binding.radioGroupIngestion.clearCheck()
        binding.radioGroupDolorA.clearCheck()
    }
}