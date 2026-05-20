package com.example.idgs905baseandroid.DistanciaPuntos

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idgs905baseandroid.R
import kotlin.math.pow
import kotlin.math.sqrt

class distanciapuntos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distanciapuntos)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtX1 = findViewById<EditText>(R.id.edtX1)
        val edtY1 = findViewById<EditText>(R.id.edtY1)
        val edtX2 = findViewById<EditText>(R.id.edtX2)
        val edtY2 = findViewById<EditText>(R.id.edtY2)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        btnCalcular.setOnClickListener {
            val strX1 = edtX1.text.toString()
            val strY1 = edtY1.text.toString()
            val strX2 = edtX2.text.toString()
            val strY2 = edtY2.text.toString()

            if (strX1.isEmpty() || strY1.isEmpty() || strX2.isEmpty() || strY2.isEmpty()) {
                Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val x1 = strX1.toDouble()
            val y1 = strY1.toDouble()
            val x2 = strX2.toDouble()
            val y2 = strY2.toDouble()

            val distancia = sqrt((x2 - x1).pow(2) + (y2 - y1).pow(2))

            txtResultado.text = String.format("Resultado: %.4f", distancia)
        }
    }
}