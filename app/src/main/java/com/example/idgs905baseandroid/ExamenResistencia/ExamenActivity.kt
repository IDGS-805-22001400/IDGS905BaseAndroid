package com.example.idgs905baseandroid.ExamenResistencia

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.idgs905baseandroid.R
import kotlin.math.pow

class ExamenActivity : AppCompatActivity() {

    private val coloresNombres = arrayOf("Negro", "Marrón", "Rojo", "Naranja", "Amarillo", "Verde", "Azul", "Violeta", "Gris", "Blanco")
    private val coloresHex = intArrayOf(Color.BLACK, Color.rgb(165, 42, 42), Color.RED, Color.rgb(255, 165, 0), Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.GRAY, Color.WHITE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_examen)

        val spinner1 = findViewById<Spinner>(R.id.spinnerBanda1)
        val spinner2 = findViewById<Spinner>(R.id.spinnerBanda2)
        val spinnerMult = findViewById<Spinner>(R.id.spinnerMultiplicador)
        val tvValor1 = findViewById<TextView>(R.id.tvValor1)
        val tvValor2 = findViewById<TextView>(R.id.tvValor2)
        val tvValorMult = findViewById<TextView>(R.id.tvValorMult)
        val viewTol = findViewById<View>(R.id.viewTolerancia)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupTolerancia)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvOhm = findViewById<TextView>(R.id.tvValorOhm)
        val tvMax = findViewById<TextView>(R.id.tvValorMax)
        val tvMin = findViewById<TextView>(R.id.tvValorMin)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, coloresNombres)
        spinner1.adapter = adapter
        spinner2.adapter = adapter
        spinnerMult.adapter = adapter

        val listener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                tvValor1.setBackgroundColor(coloresHex[spinner1.selectedItemPosition])
                tvValor1.text = spinner1.selectedItemPosition.toString()

                tvValor2.setBackgroundColor(coloresHex[spinner2.selectedItemPosition])
                tvValor2.text = spinner2.selectedItemPosition.toString()

                tvValorMult.setBackgroundColor(coloresHex[spinnerMult.selectedItemPosition])
                val multValue = 10.0.pow(spinnerMult.selectedItemPosition.toDouble()).toInt()
                tvValorMult.text = multValue.toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spinner1.onItemSelectedListener = listener
        spinner2.onItemSelectedListener = listener
        spinnerMult.onItemSelectedListener = listener

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            viewTol.setBackgroundColor(if (checkedId == R.id.rbOro) Color.rgb(255, 215, 0) else Color.LTGRAY)
        }

        btnCalcular.setOnClickListener {
            val d1 = spinner1.selectedItemPosition
            val d2 = spinner2.selectedItemPosition
            val mult = 10.0.pow(spinnerMult.selectedItemPosition.toDouble())
            val valor = (d1 * 10 + d2) * mult
            val porcentaje = if (radioGroup.checkedRadioButtonId == R.id.rbOro) 0.05 else 0.10
            val margen = valor * porcentaje

            tvOhm.text = "valor ohm: ${valor.toInt()}"
            tvMax.text = "valor maximo: ${(valor + margen).toInt()}"
            tvMin.text = "valor minimo: ${(valor - margen).toInt()}"

            tvOhm.visibility = View.VISIBLE
            tvMax.visibility = View.VISIBLE
            tvMin.visibility = View.VISIBLE
        }
    }
}