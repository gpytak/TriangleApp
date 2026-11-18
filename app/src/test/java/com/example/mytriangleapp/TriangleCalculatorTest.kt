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
    // checkTriangle() tests
    // --------------------------------
    //@TODO - Sprint 3

    // --------------------------------
    // convertToNumber() tests
    // --------------------------------
    //@TODO- Sprint 2
    @Test
    fun convertToNumber_validInteger() {
        assertEquals(123.0, calculator.convertToNumber("123")!!, 0.0001)
    }

    // --------------------------------
    // classifyTriangle() tests
    // --------------------------------
    //@TODO- Sprint 2
    @Test
    fun classifyTriangle_equilateral() {
        assertEquals(
            "Equilateral!",
            calculator.classifyTriangle(3.0, 3.0, 3.0)
        )
    }



    // Examples
    @Test
    fun addition_isCorrect()
    {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun true_isTrue()
    {
        assertTrue( 1 != 2)
    }

    @Test
    fun false_isFalse()
    {
        assertFalse( 1 == 2)
    }

    @Test
    fun null_isNull()
    {
        assertNull(null)
    }
}