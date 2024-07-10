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

                //Nivel Rojo
                Pair(R.id.radioButtonSiDificultad, R.id.radioButtonNoDificultad) to "Dificultad respiratoria severa",
                Pair(R.id.radioButtonSiColoracion, R.id.radioButtonNoColoracion) to "Coloración azul en piel",
                Pair(R.id.radioButtonSiFrialdad, R.id.radioButtonNoFrialdad) to "Frialdad generalizada",
                Pair(R.id.radioButtonSiTraumatismos, R.id.radioButtonNoTraumatismos) to "Traumatismos severos múltiples",
                Pair(R.id.radioButtonSiQuemaduras, R.id.radioButtonNoQuemaduras) to "Quemaduras en todo el cuerpo",
                Pair(R.id.radioButtonSiPerdida, R.id.radioButtonNoPerdida) to "Pérdida de miembro u órgano",
                Pair(R.id.radioButtonSiHemorragia, R.id.radioButtonNoHemorragia) to "Hemorragia masiva",
                Pair(R.id.radioButtonSiTrabajo, R.id.radioButtonNoTrabajo) to "Trabajo de parte expulsivo",
                Pair(R.id.radioButtonSiAbuso, R.id.radioButtonNoAbuso) to "Abuso sexual",

                //Nivel Naranja

                Pair(R.id.radioButtonSiAlteracion, R.id.radioButtonNoAlteracion) to "Alteración aguda de signos vitales",
                Pair(R.id.radioButtonSiEstado , R.id.radioButtonNoEstado) to "Estado convulsivo",
                Pair(R.id.radioButtonSiDeficiencia, R.id.radioButtonNoDeficiencia) to "Deficiencia respiratoria moderada",
                Pair(R.id.radioButtonSiCrisis, R.id.radioButtonNoCrisis) to "Crisis hipertensiva",
                Pair(R.id.radioButtonSiDiabetes, R.id.radioButtonNoDiabetes) to "Diabetes descompensada",
                Pair(R.id.radioButtonSiDolor, R.id.radioButtonNoDolor) to "Dolor torácico",
                Pair(R.id.radioButtonSiTrauma, R.id.radioButtonNoTrauma) to "Trauma severo",
                Pair(R.id.radioButtonSiQuemadura, R.id.radioButtonNoQuemadura) to "Quemadura de III grado",
                Pair(R.id.radioButtonSiRiesgo, R.id.radioButtonNoRiesgo) to "Riesgo de pérdida de miembro u órgano",
                Pair(R.id.radioButtonSiFractura, R.id.radioButtonNoFractura) to "Fractura",
                Pair(R.id.radioButtonSiDigestivo, R.id.radioButtonNoDigestivo) to "Hemorragia digestiva",
                Pair(R.id.radioButtonSiSangrado, R.id.radioButtonNoSangrado) to "Sangrado vaginal en embarazadas",
                Pair(R.id.radioButtonSiTrabajoP, R.id.radioButtonNoTrabajoP) to "Trabajo de parto",
                Pair(R.id.radioButtonSiAbusoS, R.id.radioButtonNoAbusoS) to "Abuso sexual antiguo",
                Pair(R.id.radioButtonSiAgitacion, R.id.radioButtonNoAgitacion) to "Agitación psicomotora",
                Pair(R.id.radioButtonSiIngestion, R.id.radioButtonNoIngestion) to "Ingestión de sustancias toxicas o envenenamiento",
                Pair(R.id.radioButtonSiDolorA, R.id.radioButtonNoDolorA) to "Dolor agudo",

                //Nivel Amarillo

                Pair(R.id.radioButtonSiFiebre, R.id.radioButtonNoFiebre) to "Fiebre mayor 38.5°C",
                Pair(R.id.radioButtonSiVertigo, R.id.radioButtonNoVertigo) to "Vértigo severo",
                Pair(R.id.radioButtonSiDificultadR, R.id.radioButtonNoDificultadR) to "Dificultad respiratoria leve",
                Pair(R.id.radioButtonSiVomito, R.id.radioButtonNoVomito) to "Vómito y diarrea con deshidratacion",
                Pair(R.id.radioButtonSiSintomas, R.id.radioButtonNoSintomas) to "Síntomas asociadas o diálisis",
                Pair(R.id.radioButtonSiDolorM, R.id.radioButtonNoDolorM) to "Dolor moderado de menos de 24 horas",
                Pair(R.id.radioButtonSiTraumaM, R.id.radioButtonNoTraumaM) to "Trauma moderado",
                Pair(R.id.radioButtonSiQuemaduraG, R.id.radioButtonNoQuemaduraG) to "Quemadura ll o l grado",
                Pair(R.id.radioButtonSiSangradoM , R.id.radioButtonNoSangradoM)to "Sangrado moderado",
                Pair(R.id.radioButtonSiReaccion, R.id.radioButtonNoReaccion) to "Reacción alérgica con brote generalizado",
                Pair(R.id.radioButtonSiEvento, R.id.radioButtonNoEvento) to "Todo Evento en Salud Pública que consulte",

                //Nivel Verde

                Pair(R.id.radioButtonSiFiebreM, R.id.radioButtonNoFiebreM) to "Fiebre mayor 38.5°c",
                Pair(R.id.radioButtonSiTos, R.id.radioButtonNoTos) to "Tos y congestión",
                Pair(R.id.radioButtonSiFaringitis, R.id.radioButtonNoFaringitis) to "Faringitis o amigdalitis",
                Pair(R.id.radioButtonSiVomito, R.id.radioButtonNoVomito) to "Vómito y diarrea sin deshidratación",
                Pair(R.id.radioButtonSiDolorL, R.id.radioButtonNoDolorL) to "Dolor leve",
                Pair(R.id.radioButtonSiDolorH, R.id.radioButtonNoDolorH) to "Dolor moderado de más de 24 horas",
                Pair(R.id.radioButtonSiTraumaL, R.id.radioButtonNoTraumaL) to "Trauma leve",
                Pair(R.id.radioButtonSiSignos, R.id.radioButtonNoSignos) to "Signos de Infección local",
                Pair(R.id.radioButtonSiArdor, R.id.radioButtonNoArdor) to "Ardor al orinar",
                Pair(R.id.radioButtonSiEnfermedad, R.id.radioButtonNoEnfermedad) to "Enfermedad venérea aguda. Ansiedad y depresión",
                Pair(R.id.radioButtonSiColico, R.id.radioButtonNoColico) to "Cólico menstrual",

                //Nivel Azul

                Pair(R.id.radioButtonSiSintomas, R.id.radioButtonNoSintomas) to "Sintomas agudas que no comprometan el estado general",
                Pair(R.id.radioButtonSiDolorC, R.id.radioButtonNoDolorC) to "Dolor de cabeza crónico",
                Pair(R.id.radioButtonSiTosC, R.id.radioButtonNoTosC) to "Tos crónica",
                Pair(R.id.radioButtonSiInapetencia, R.id.radioButtonNoInapetencia) to "Inapetencia",
                Pair(R.id.radioButtonSiDiarrea, R.id.radioButtonNoDiarrea) to "Diarrea crónica. Estreñimiento",
                Pair(R.id.radioButtonSiDolorAC, R.id.radioButtonNoDolorAC) to "Dolor abdominal crónico",
                Pair(R.id.radioButtonSiDolorP, R.id.radioButtonNoDolorP) to "Dolor postraumático leve",
                Pair(R.id.radioButtonSiDermatitis, R.id.radioButtonNoDermatitis) to "Dermatitis",
                Pair(R.id.radioButtonSiEstres, R.id.radioButtonNoEstres) to "Estrés emocional",
                Pair(R.id.radioButtonSiEnfermedadC, R.id.radioButtonNoEnfermedadC) to "Enfermedades crónicas",
                Pair(R.id.radioButtonSiFormulacion, R.id.radioButtonNoFormulacion) to "Formulación de medicamentos",
                Pair(R.id.radioButtonSiLectura, R.id.radioButtonNoLectura) to "Lectura de exámenes",
            )



            for ((idYes, idNo) in questions.keys) {
                val answer = if (findViewById<RadioButton>(idYes).isChecked) "Sí" else "No"
                answers[questions.getValue(Pair(idYes, idNo))] = answer
            }


            val intent = Intent(this, Resultados::class.java).apply {
                putExtra("respuestas", answers)
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
        //Clear Nivel Rojo
        binding.radioGroupDificultad.clearCheck()
        binding.radioGroupColoracion.clearCheck()
        binding.radioGroupFrialdad.clearCheck()
        binding.radioGroupTraumatismos.clearCheck()
        binding.radioGroupQuemaduras.clearCheck()
        binding.radioGroupPerdida.clearCheck()
        binding.radioGroupHemorragia.clearCheck()
        binding.radioGroupTrabajo.clearCheck()
        binding.radioGroupAbuso.clearCheck()

        //Clear Nivel Naranja
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

        //Clear Nivel Amarillo

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

        //Clear Nivel Verde

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

        //Clear Nivel Azul

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
