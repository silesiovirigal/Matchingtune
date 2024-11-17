package com.example.matchingtunes

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.matchingtunes.databinding.ActivitySignuppart2Binding

class signuppart2 : AppCompatActivity() {

    private lateinit var binding: ActivitySignuppart2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySignuppart2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.voltarMain.setOnClickListener(){
            val i = Intent(this, com.example.matchingtunes.MainActivity::class.java)
            startActivity(i)
        }
        binding.myButtonSeguinte.setOnClickListener(){

            val name = binding.userName2.text.toString()
            val secondname = binding.apelido
            if (name.isEmpty()) {
                binding.userName2.error = "Nome não pode estar vazio"
                return@setOnClickListener
            }
            if (name.isEmpty()) {
                binding.apelido.error = "apelido não pode estar vazio"
                return@setOnClickListener
            }

            val a = Intent(this, com.example.matchingtunes.signuppart3::class.java)
            startActivity(a)
        }


    }
}