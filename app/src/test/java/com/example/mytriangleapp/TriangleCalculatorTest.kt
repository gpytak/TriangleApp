package com.example.mytriangleapp

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TriangleCalculatorTest
{
    private lateinit var calculator: TriangleCalculator

    // Runs setUp() before each test to create a new instance of TriangleCalculator.
    @Before
    fun setUp()
    {
        calculator = TriangleCalculator()
    }

    // --------------------------------
    // isValidTriangle() tests
    // --------------------------------
    @Test
    fun isValidTriangle_invalidIsosceles1() {
        assertFalse(calculator.isValidTriangle(2.0, 2.0, 5.0)
        )
    }
    @Test
    fun isValidTriangle_invalidIsosceles2() {
        assertFalse(calculator.isValidTriangle(1.0, 3.0, 1.0)
        )
    }
    @Test
    fun isValidTriangle_invalidScalene() {
        assertFalse(calculator.isValidTriangle(3.0, 4.0, 8.0)
        )
    }
    @Test
    fun isValidTriangle_scalene() {
        assertTrue(calculator.isValidTriangle(2.0, 3.0, 4.0)
        )
    }
    @Test
    fun isValidTriangle_isosceles() {
        assertTrue(calculator.isValidTriangle(3.0, 3.0, 5.0)
        )
    }
    @Test
    fun isValidTriangle_equilateral() {
        assertTrue(calculator.isValidTriangle(5.0, 5.0, 5.0)
        )
    }

    // --------------------------------
    // checkTriangle() tests
    // --------------------------------
    @Test
    fun checkTriangle_empty() {
        assertEquals(
            "ERROR: Enter three real numbers or integers between 1.0 and 100.0.",
            calculator.checkTriangle("", "1.0", "1.0")
        )
    }
    @Test
    fun checkTriangle_integer() {
        assertEquals(
            "ERROR: Enter three real numbers or integers between 1.0 and 100.0.",
            calculator.checkTriangle("-10.0", "10.0", "1.0")
        )
    }
    @Test
    fun checkTriangle_zeros() {
        assertEquals(
            "ERROR: Enter three real numbers or integers between 1.0 and 100.0.",
            calculator.checkTriangle("-0.0", "-0.0", "-0.0")
        )
    }
    @Test
    fun checkTriangle_invalid1() {
        assertEquals(
            "ERROR: Not a valid triangle!\nThe sum of any two sides must be greater than the third side.",
            calculator.checkTriangle("5.0", "2.0", "2.0")
        )
    }
    @Test
    fun checkTriangle_invalid2() {
        assertEquals(
            "ERROR: Not a valid triangle!\nThe sum of any two sides must be greater than the third side.",
            calculator.checkTriangle("2.0", "5.0", "2.0")
        )
    }
    @Test
    fun checkTriangle_invalid3() {
        assertEquals(
            "ERROR: Not a valid triangle!\nThe sum of any two sides must be greater than the third side.",
            calculator.checkTriangle("2.0", "2.0", "5.0")
        )
    }
    @Test
    fun checkTriangle_lowerBoundary1() {
        assertEquals(
            "ERROR: Enter three real numbers or integers between 1.0 and 100.0.",
            calculator.checkTriangle("0.2", "1.0", "1.1")
        )
    }
    @Test
    fun checkTriangle_lowerBoundary2() {
        assertEquals(
            "ERROR: Enter three real numbers or integers between 1.0 and 100.0.",
            calculator.checkTriangle("1.0", "0.2", "1.1")
        )
    }
    @Test
    fun checkTriangle_lowerBoundary3() {
        assertEquals(
            "ERROR: Enter three real numbers or integers between 1.0 and 100.0.",
            calculator.checkTriangle("1.0", "1.1", "0.2")
        )
    }
    @Test
    fun checkTriangle_lowerBoundary4() {
        assertEquals(
            "ERROR: Enter three real numbers or integers between 1.0 and 100.0.",
            calculator.checkTriangle("0.3", "0.2", "0.4")
        )
    }
    @Test
    fun checkTriangle_upperBoundary1() {
        assertEquals(
            "ERROR: Enter three real numbers or integers between 1.0 and 100.0.",
            calculator.checkTriangle("101.0", "5.0", "97.0")
        )
    }
    @Test
    fun checkTriangle_upperBoundary2() {
        assertEquals(
            "ERROR: Enter three real numbers or integers between 1.0 and 100.0.",
            calculator.checkTriangle("5.0", "101.0", "97.0")
        )
    }
    @Test
    fun checkTriangle_upperBoundary3() {
        assertEquals(
            "ERROR: Enter three real numbers or integers between 1.0 and 100.0.",
            calculator.checkTriangle("97.0", "5.0", "101.0")
        )
    }
    @Test
    fun checkTriangle_upperBoundary4() {
        assertEquals(
            "ERROR: Enter three real numbers or integers between 1.0 and 100.0.",
            calculator.checkTriangle("103.0", "102.0", "104.0")
        )
    }
    
    // --------------------------------
    // classifyTriangle() tests
    // --------------------------------
    @Test
    fun classifyTriangle_scalene() {
        assertEquals(
            "Scalene!",
            calculator.classifyTriangle(3.0, 4.0, 5.0)
        )
    }
    @Test
    fun classifyTriangle_isosceles() {
        assertEquals(
            "Isosceles!",
            calculator.classifyTriangle(3.0, 3.0, 5.0)
        )
    }
    @Test
    fun classifyTriangle_equilateral() {
        assertEquals(
            "Equilateral!",
            calculator.classifyTriangle(3.0, 3.0, 3.0)
        )
    }
    @Test
    fun classifyTriangle_lowerBoundary() {
        assertEquals(
            "Equilateral!",
            calculator.classifyTriangle(1.0, 1.0, 1.0)
        )
    }
    @Test
    fun classifyTriangle_upperBoundary() {
        assertEquals(
            "Equilateral!",
            calculator.classifyTriangle(100.0, 100.0, 100.0)
        )
    }

    // --------------------------------
    // convertToNumber() tests
    // --------------------------------
    @Test
    fun convertToNumber_validInteger() {
        assertEquals(5.0, calculator.convertToNumber("5")!!, 0.0001)
    }
    @Test
    fun convertToNumber_zeroInput() {
        assertEquals(0.0, calculator.convertToNumber("0")!!, 0.0001)
    }
    @Test
    fun convertToNumber_decimalInput() {
        assertEquals(2.5, calculator.convertToNumber("2.5")!!, 0.0001)
    }
    @Test
    fun convertToNumber_negativeInput() {
        assertEquals(-7.0, calculator.convertToNumber("-7")!!, 0.0001)
    }
    @Test
    fun convertToNumber_emptyInput() {
        assertNull(calculator.convertToNumber(""))
    }
    @Test
    fun convertToNumber_invalidString() {
        assertNull(calculator.convertToNumber("a"))
    }
    @Test
    fun convertToNumber_invalidInteger() {
        assertNull(calculator.convertToNumber("1.1.1"))
    }
    @Test
    fun convertToNumber_invalidChar() {
        assertNull(calculator.convertToNumber("!"))
    }
}