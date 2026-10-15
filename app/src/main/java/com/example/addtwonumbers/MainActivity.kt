package com.example.addtwonumbers

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numA = findViewById<EditText>(R.id.numA)
        val numB = findViewById<EditText>(R.id.numB)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val result = findViewById<TextView>(R.id.result)

        btnAdd.setOnClickListener {

            val textA = numA.text.toString().trim()
            val textB = numB.text.toString().trim()

            // Проверка первого поля
            if (textA.isEmpty()) {
                numA.error = "Введите первое число"
                numA.requestFocus()
                return@setOnClickListener
            }

            if (textB.isEmpty()) {
                numB.error = "Введите второе число"
                numB.requestFocus()
                return@setOnClickListener
            }

            val a = textA.replace(',', '.').toDoubleOrNull()
            val b = textB.replace(',', '.').toDoubleOrNull()

            if (a == null || b == null ||
                !a.isFinite() || !b.isFinite()
            ) {
                Toast.makeText(
                    this,
                    "Введите корректные числа",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val sum = a + b


            val formattedSum = String.format(
                Locale.US,
                "%.10f",
                sum
            ).trimEnd('0').trimEnd('.')

            result.text = "Результат: $formattedSum"
        }
    }
}