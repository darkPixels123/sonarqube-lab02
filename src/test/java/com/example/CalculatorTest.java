package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void testCalculate() {
        Calculator calc = new Calculator();
        // Covering different branches of the switch statement
        assertEquals(15, calc.calculate(10, 5, "add"));
        assertEquals(5, calc.calculate(10, 5, "sub"));
        assertEquals(50, calc.calculate(10, 5, "mul"));
        assertEquals(2, calc.calculate(10, 5, "div"));
        assertEquals(0, calc.calculate(10, 0, "div")); // Test division by zero branch
        assertEquals(0, calc.calculate(10, 5, "unknown")); // Test default branch
    }
}