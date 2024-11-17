package com.example.matchingtunes

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.matchingtunes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        binding.myButtonEntrar.setOnClickListener(){

            val username = binding.userName.text.toString().trim()
            val password = binding.passWord.text.toString().trim()


            if (username.isEmpty()) {
                binding.userName.error = "Nome de usuário obrigatório"
                binding.userName.requestFocus()

            }

            if (username.isEmpty()) {
                binding.passWord.error = "Senha obrigatória"
                binding.passWord.requestFocus()

            }

            if (password.length < 6) {
                binding.passWord.error = "A senha deve ter pelo menos 6 caracteres"
                binding.passWord.requestFocus()

            }

            Toast.makeText(this, "login feito!", Toast.LENGTH_SHORT).show()
        }


        binding.inscrever.setOnClickListener() {
            val i = Intent(this, com.example.matchingtunes.signuppart2::class.java)
            startActivity(i)
        }


    }


}