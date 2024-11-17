package com.example.matchingtunes

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.matchingtunes.databinding.ActivitySignuppart3Binding

class signuppart3 : AppCompatActivity() {

    private lateinit var spinnerMonth: Spinner
    private lateinit var spinnerDay: Spinner
    private lateinit var spinnerYear: Spinner

    private lateinit var binding: ActivitySignuppart3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySignuppart3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        spinnerMonth = findViewById(R.id.spinner_month)
        spinnerDay = findViewById(R.id.spinner_day)
        spinnerYear = findViewById(R.id.spinner_year)

        val months = arrayOf("Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro")
        val monthAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, months)
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerMonth.adapter = monthAdapter

        val days = (1..31).map { it.toString() }
        val dayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, days)
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerDay.adapter = dayAdapter

        val daysInMonth = intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

        val years = (1900..2024).map { it.toString() }
        val yearAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, years)
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerYear.adapter = yearAdapter

        binding.btnVoltar.setOnClickListener(){
            val a = Intent(this, com.example.matchingtunes.signuppart2::class.java)
            startActivity(a)
        }

        binding.myButtonSeguinte3.setOnClickListener(){

            val selecdDay = binding.spinnerDay.selectedItem.toString()
            val selectMonth = binding.spinnerMonth.selectedItem.toString()
            val selectYear = binding.spinnerYear.selectedItem.toString()

            val email = binding.emailsign.getText().toString()

            if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.emailsign.setError("Insira um e-mail válido");

                return@setOnClickListener;
            }

            val a = Intent(this, com.example.matchingtunes.signuuppart4::class.java)
            startActivity(a)
        }

    }
}