package com.example.idgs905baseandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idgs905baseandroid.Ejemplo1.ejemplo1
import com.example.idgs905baseandroid.DistanciaPuntos.distanciapuntos
import com.example.idgs905baseandroid.Ejemplo2.Ejemplo2Activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btnEjemplo1=findViewById<Button>(R.id.btn1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnEjemplo1.setOnClickListener { navegateToEjemplo1() }
        val btnDistanciaPuntos=findViewById<Button>(R.id.btn2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnDistanciaPuntos.setOnClickListener { navegateToDistanciaPuntos() }
        val btnEjemplo2=findViewById<Button>(R.id.btn3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnEjemplo2.setOnClickListener { navegateToEjemplo2() }
    }

    fun navegateToEjemplo1(){
        val intent= Intent(this, ejemplo1::class.java)
        startActivity(
            intent
        )
    }

    fun navegateToDistanciaPuntos(){
        val intent= Intent(this, distanciapuntos::class.java)
        startActivity(
            intent
        )
    }

    fun navegateToEjemplo2(){
        val intent= Intent(this, Ejemplo2Activity::class.java)
        startActivity(
            intent
        )
    }
}