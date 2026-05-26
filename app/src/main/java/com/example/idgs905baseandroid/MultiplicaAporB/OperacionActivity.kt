package com.example.idgs905baseandroid.MultiplicaAporB

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idgs905baseandroid.R

class OperacionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_operacion)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etNumeroA = findViewById<EditText>(R.id.etNumeroA)
        val etNumeroB = findViewById<EditText>(R.id.etNumeroB)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        btnCalcular.setOnClickListener {
            val strA = etNumeroA.text.toString()
            val strB = etNumeroB.text.toString()

            if (strA.isNotEmpty() && strB.isNotEmpty()) {
                val numA = strA.toInt()
                val numB = strB.toInt()

                val intent = Intent(this, ResultadoActivity::class.java).apply {
                    putExtra("NUMERO_A", numA)
                    putExtra("NUMERO_B", numB)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, llena ambos campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}