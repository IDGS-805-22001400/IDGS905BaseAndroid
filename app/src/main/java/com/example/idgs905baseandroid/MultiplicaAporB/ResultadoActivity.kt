package com.example.idgs905baseandroid.MultiplicaAporB

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idgs905baseandroid.R

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvPasos = findViewById<TextView>(R.id.tvPasos)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        val numA = intent.getIntExtra("NUMERO_A", 0)
        val numB = intent.getIntExtra("NUMERO_B", 0)

        val resultado = numA * numB
        val pasosBuilder = StringBuilder()

        if (numB > 0) {
            for (i in 1..numB) {
                pasosBuilder.append(numA)
                if (i < numB) {
                    pasosBuilder.append("+")
                }
            }
        } else if (numB == 0) {
            pasosBuilder.append("0")
        } else {
            pasosBuilder.append("Operación con B negativo")
        }

        tvPasos.text = "Pasos: ${pasosBuilder.toString()}"
        tvResultado.text = "Resultado: $resultado"
    }
}