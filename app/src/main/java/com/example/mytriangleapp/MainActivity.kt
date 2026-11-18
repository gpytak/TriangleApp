
package com.example.mytriangleapp

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : Activity()
{
    // Android components
    private lateinit var side1: EditText
    private lateinit var side2: EditText
    private lateinit var side3: EditText

    private lateinit var checkTriangleButton: Button
    private lateinit var resetButton: Button

    private lateinit var result: TextView

    // Create an instance of TriangleCalculator.
    private val triangleCalculator = TriangleCalculator()


    // onCreate - Main driver for the game.
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)     // Initialize Activity.
        setContentView(R.layout.activity_main) // Load the XML layout onto the screen.
        initializeViews()                      // Connect to the visual components in the XML.
        setupButtons()                         // Assigns functionality to the buttons.
    }

    // initializeViews - Connect the Android components to the XML elements.
    private fun initializeViews()
    {
        // Connect to the sides.
        side1 = findViewById(R.id.side1)
        side2 = findViewById(R.id.side2)
        side3 = findViewById(R.id.side3)

        // Connect to the buttons.
        checkTriangleButton = findViewById(R.id.checkTriangleButton)
        resetButton         = findViewById(R.id.resetButton)

        // Connect to the result.
        result = findViewById(R.id.result)
    }

    // setupButtons - Assign functionality to the buttons.
    private fun setupButtons()
    {
        checkTriangleButton.setOnClickListener {
            checkTriangle()
        }

        resetButton.setOnClickListener {
            resetGame()
        }
    }

    // checkTriangle - Processes the user's inputs.
    private fun checkTriangle()
    {
        // Convert the inputs from Editables into regular Strings.
        val text1 = side1.text.toString().trim()
        val text2 = side2.text.toString().trim()
        val text3 = side3.text.toString().trim()

        // Check for the escape value (0).
        if (text1 == "0" || text2 == "0" || text3 == "0")
        {
            finish()
            return
        }

        // Identify and display the triangle type.
        result.text = triangleCalculator.checkTriangle(text1, text2, text3)
    }

    // Reset the game
    private fun resetGame()
    {
        side1.text.clear()
        side2.text.clear()
        side3.text.clear()

        result.text = "Result"
    }
}
