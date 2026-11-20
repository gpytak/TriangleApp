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
    //@TODO - Sprint 3
    @Test
    fun isValidTriangle_isosceles1() {
        assertEquals(
            false,
            calculator.isValidTriangle(2.0, 2.0, 5.0)
        )
    }
    @Test
    fun isValidTriangle_isosceles2() {
        assertEquals(
            false,
            calculator.isValidTriangle(1.0, 3.0, 1.0)
        )
    }
    @Test
    fun isValidTriangle_scalene() {
        assertEquals(
            false,
            calculator.isValidTriangle(3.0, 4.0, 8.0)
        )
    }

    // --------------------------------
    // checkTriangle() tests
    // --------------------------------
    //@TODO - Sprint 3
    @Test
    fun checkTriangle_decimal() {
        assertEquals(
            "ERROR: Enter three positive real numbers or integers.",
            calculator.checkTriangle("-0.01", "1.0", "1.0")
        )
    }
    @Test
    fun checkTriangle_integer() {
        assertEquals(
            "ERROR: Enter three positive real numbers or integers.",
            calculator.checkTriangle("-10.0", "10.0", "1.0")
        )
    }
    @Test
    fun checkTriangle_zeros() {
        assertEquals(
            "ERROR: Enter three positive real numbers or integers.",
            calculator.checkTriangle("-0.0", "-0.0", "-0.0")
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