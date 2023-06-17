package com.ervr.calculadora1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
/*
En Kotlin, las variables pueden ser declaradas como nulas agregando el operador de interrogación (?)
 después del tipo de dato. En el código de Kotlin, las variables editTextNumber1, editTextNumber2 y
 textViewResult son declaradas como EditText? y TextView?, lo que significa que pueden contener
 valores nulos.
 */
    private var editTextNumber1: EditText? = null
    private var editTextNumber2: EditText? = null
    private var textViewResult: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        Kotlin proporciona una inferencia de tipo más poderosa en comparación con Java.
        Por lo tanto, no es necesario especificar explícitamente el tipo de datos al
        inicializar las variables en Kotlin.
         */
        editTextNumber1 = findViewById(R.id.editTextNumber1)
        editTextNumber2 = findViewById(R.id.editTextNumber2)
        textViewResult = findViewById(R.id.textViewResult)
        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val buttonSubtract = findViewById<Button>(R.id.buttonSubtract)
        val buttonMultiply = findViewById<Button>(R.id.buttonMultiply)
        val buttonDivide = findViewById<Button>(R.id.buttonDivide)
        buttonAdd.setOnClickListener {
            Log.d("MainActivity", "Metodo Suma")
            calculateResult('+') }
        buttonSubtract.setOnClickListener {
            Log.d("MainActivity", "Metodo Resta")
            calculateResult('-') }
        buttonMultiply.setOnClickListener {
            Log.d("MainActivity", "Metodo Multiplicar")
            calculateResult('*') }
        buttonDivide.setOnClickListener {
            Log.d("MainActivity", "Metodo Dividir")
            calculateResult('/') }
        val buttonExit = findViewById<Button>(R.id.buttonExit)
        buttonExit.setOnClickListener { finish() }
    }

    private fun calculateResult(operator: Char) {
        /*
        En el código de Java, se utiliza la interfaz OnClickListener y se crea una instancia
        anónima para definir el comportamiento del click listener. En Kotlin, se utilizan
        las expresiones lambda más concisas para definir los click listeners.
         */
        val value1 = editTextNumber1!!.text.toString()
        val value2 = editTextNumber2!!.text.toString()
        /*
        En el código de Kotlin, se utiliza el operador de llamada segura (?.)
        para acceder a las propiedades o métodos de los objetos potencialmente nulos.
         */
        if (!value1.isEmpty() && !value2.isEmpty()) {
            val num1 = value1.toDouble()
            val num2 = value2.toDouble()
            var result = 0.0
            when (operator) {
                '+' -> result = num1 + num2
                '-' -> result = num1 - num2
                '*' -> result = num1 * num2
                '/' -> if (num2 != 0.0) result = num1 / num2 else Toast.makeText(
                    applicationContext,
                    "No se puede dividir por cero",
                    Toast.LENGTH_SHORT
                ).show()
            }
            textViewResult!!.text = "Resultado: $result"
            Log.d("MainActivity", result.toString())
        } else {
            Toast.makeText(applicationContext, "Ingrese ambos valores", Toast.LENGTH_SHORT).show()
            Log.d("MainActivity", "Ingrese ambos valores")
        }
    }
}