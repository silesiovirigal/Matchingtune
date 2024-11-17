package com.example.matchingtunes

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.matchingtunes.databinding.ActivitySignuppart5ConfirmarpassBinding

class signuppart5_confirmarpass : AppCompatActivity() {

    private lateinit var binding: ActivitySignuppart5ConfirmarpassBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySignuppart5ConfirmarpassBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnVoltar5 .setOnClickListener(){
            val a = Intent(this, com.example.matchingtunes.signuuppart4::class.java)
            startActivity(a)
        }
    }
}