package com.alexdevs.menu

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alexdevs.menu.databinding.ActivityMenuEncuestaBinding

class MenuEncuesta : AppCompatActivity() {

    private lateinit var binding: ActivityMenuEncuestaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMenuEncuestaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.IbRegresar.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.BtnEncuestaUno.setOnClickListener {
            val intent = Intent(this@MenuEncuesta, EncuestaRojo::class.java)
            startActivity(intent)
        }

//        binding.BtnEncuestaDos.setOnClickListener {
//            val intent = Intent(this@MenuEncuesta, EncuestaNaranja::class.java)
//            startActivity(intent)
//        }
//
//        binding.BtnEncuestaTres.setOnClickListener {
//            val intent = Intent(this@MenuEncuesta, EncuestaAmarilla::class.java)
//            startActivity(intent)
//        }
//
//        binding.BtnEncuestaCuatro.setOnClickListener {
//            val intent = Intent(this@MenuEncuesta, EncuestaVerde::class.java)
//            startActivity(intent)
//        }
//
//        binding.BtnEncuestaCinco.setOnClickListener {
//            val intent = Intent(this@MenuEncuesta, EncuestaAzul::class.java)
//            startActivity(intent)
//        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}