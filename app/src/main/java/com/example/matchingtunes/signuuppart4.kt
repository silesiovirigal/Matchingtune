package com.example.matchingtunes

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.matchingtunes.databinding.ActivitySignuuppart4Binding

class signuuppart4 : AppCompatActivity() {

    private lateinit var binding: ActivitySignuuppart4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignuuppart4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnVoltar4.setOnClickListener(){
            val a = Intent(this, com.example.matchingtunes.signuppart3::class.java)
            startActivity(a)
        }

        binding.myButtonSeguinte4 .setOnClickListener(){

            val codigoComfirm = binding.passwordSignup.text.toString()
            val codigoComfirm2 = binding.passwordSignup2.text.toString()

            if (codigoComfirm.length < 6) {
                binding.passwordSignup.error = "A senha deve ter no mínimo 6 caracteres"
                return@setOnClickListener
            }


            if (codigoComfirm != codigoComfirm2) {
                binding.passwordSignup2.error = "As senhas não coincidem"
                return@setOnClickListener
            }

            val a = Intent(this, com.example.matchingtunes.signuppart5_confirmarpass::class.java)
            startActivity(a)
        }
    }
}