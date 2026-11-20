package com.example.mytriangleapp

class TriangleCalculator
{
    // checkTriangle - Verifies that the player has provided valid inputs.
    fun checkTriangle(text1: String, text2: String, text3: String): String
    {
        // Check that all three inputs have been entered.
        if (text1.isEmpty() || text2.isEmpty() || text3.isEmpty())
        {
            return "ERROR: Enter three real numbers or integers."
        }

        // Convert the Strings into numbers.
        val side1 = convertToNumber(text1)
        val side2 = convertToNumber(text2)
        val side3 = convertToNumber(text3)

        // If three inputs were provided, confirm they are positive real numbers or integers.
        if (side1 == null || side2 == null || side3 == null ||
            side1 <= 0 || side2 <= 0 || side3 <= 0)
        {
            return "ERROR: Enter three positive real numbers or integers."
        }

        // Check whether the numbers form a valid triangle.
        if (!isValidTriangle(side1, side2, side3))
        {
            return "ERROR: Not a valid triangle!\nThe sum of any two sides must be greater than the third side."
        }

        return classifyTriangle(side1, side2, side3)
    }

    // convertToNumber - Converts the String into a real number.
    fun convertToNumber(input: String): Double? {
        var number = 0.0
        var decimalPlace = 0.1

        var decimalFound = false
        var negative = false
        var digitFound = false
        var i = 0

        // Check if input is empty.
        if (input.isEmpty())
        {
            return null
        }

        // Loop through each character of input.
        while (i < input.length)
        {
            val character = input[i]

            // Check to see if the input is negative.
            if (character == '-' && i == 0)
            {
                negative = true

            }
            // Check to see if the input has only one decimal.
            else if (character == '.' && !decimalFound)
            {
                decimalFound = true

            }
            // Check to see if the input is a valid digit.
            else if (character in '0'..'9')
            {
                digitFound = true

                // Construct the number digit by digit.
                // Subtracting '0' from another digit character returns the integer value.

                // Construct the whole number portion of the input.
                if (!decimalFound)
                {
                    number = number * 10 + (character - '0')
                }
                // Construct the decimal portion of the input.
                else
                {
                    number += (character - '0') * decimalPlace
                    decimalPlace /= 10
                }
            }
            else
            {
                return null
            }

            i++
        }

        // Make sure the input contained at least one digit.
        if (!digitFound)
        {
            return null
        }

        if (negative)
        {
            number = -number
        }

        return number
    }


    // isValidTriangle - Check that the sides form a valid triangle.
    fun isValidTriangle(side1: Double, side2: Double, side3: Double): Boolean
    {
        return  side1 + side2 > side3 &&
                side1 + side3 > side2 &&
                side2 + side3 > side1
    }

    // classifyTriangle - Determine the type of triangle.
    fun classifyTriangle(side1: Double, side2: Double, side3: Double): String
    {
        return when
        {
            side1 == side2 && side2 == side3 -> "Equilateral!"
            side1 == side2 || side1 == side3 || side2 == side3 -> "Isosceles!"
            else -> "Scalene!"
        }
    }
}