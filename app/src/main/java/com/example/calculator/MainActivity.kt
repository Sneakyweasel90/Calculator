package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var display: TextView
    private var currentInput: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Reference to display TextView
        display = findViewById(R.id.display)

        // Number buttons
        val button0: Button = findViewById(R.id.button0) // Change this to your actual "0" ID
        val button1: Button = findViewById(R.id.button) // You’ll need to map this to "1"
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button9)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button7)

        val buttonClear: Button = findViewById(R.id.button16)
        val buttonEquals: Button = findViewById(R.id.button13)
        val buttonPlus: Button = findViewById(R.id.button10)

        // Example number click
        button0.setOnClickListener { appendToInput("0") }
        button1.setOnClickListener { appendToInput("1") }
        button2.setOnClickListener { appendToInput("2") }
        button3.setOnClickListener { appendToInput("3") }
        button4.setOnClickListener { appendToInput("6") }
        button5.setOnClickListener { appendToInput("5") }
        button6.setOnClickListener { appendToInput("4") }
        button7.setOnClickListener { appendToInput("7") }
        button8.setOnClickListener { appendToInput("8") }
        button9.setOnClickListener { appendToInput("9") }

        buttonPlus.setOnClickListener { appendToInput("+") }
        buttonClear.setOnClickListener {
            currentInput = ""
            display.text = "0"
        }

        buttonEquals.setOnClickListener {
            try {
                val result = eval(currentInput)
                display.text = result.toString()
                currentInput = result.toString()
            } catch (e: Exception) {
                display.text = "Error"
            }
        }
    }

    private fun appendToInput(value: String) {
        currentInput += value
        display.text = currentInput
    }

    // Simple expression evaluator (only handles + for now)
    private fun eval(expression: String): Int {
        return expression.split("+").map { it.trim().toInt() }.sum()
    }
}
