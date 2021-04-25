package com.anderson.myimc

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMainCalcule.setOnClickListener {
            val peso = edtPeso.text.toString().toFloat()
            val altura = edtAltura.text.toString().toFloat()
            val imc: Float = (peso / (altura * altura))
            

            if (imc < 18.5) {
                Toast.makeText(this, "Abaixo do peso", Toast.LENGTH_SHORT).show()
            } else if (imc >= 18.5 && imc <= 24.9) {
                Toast.makeText(this, "Peso normal", Toast.LENGTH_SHORT).show()
            } else if (imc >= 25.0 && imc <= 29.9) {
                Toast.makeText(this, "Sobrepeso", Toast.LENGTH_SHORT).show()
            } else if (imc >= 30.0 && imc <= 34.9) {
                Toast.makeText(this, "Obesidade grau 1", Toast.LENGTH_SHORT).show()
            } else if (imc >= 35.0 && imc <= 39.9) {
                Toast.makeText(this, "Obesidade grau 2", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Obesidade grau 3", Toast.LENGTH_SHORT).show()
            }

            val mIntent = Intent(this, ResultActivity:: class.java)

            mIntent.putExtra("INTENT_IMC", imc)
            startActivity(mIntent)
            finish()
            }
        }
    }
