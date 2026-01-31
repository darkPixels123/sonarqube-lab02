package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void testAllBranches() {
        Calculator calc = new Calculator();
        assertEquals(15, calc.calculate(10, 5, "add"));
        assertEquals(15, calc.calculate(10, 5, "add-again"));
        assertEquals(5, calc.calculate(10, 5, "sub"));
        assertEquals(5, calc.calculate(10, 5, "sub-again"));
        assertEquals(50, calc.calculate(10, 5, "mul"));
        assertEquals(2, calc.calculate(10, 5, "div"));
        assertEquals(0, calc.calculate(10, 0, "div")); // Covers (b==0) ternary branch
        assertEquals(0, calc.calculate(10, 5, "mod")); // Covers mod case
        assertEquals(100, calc.calculate(10, 2, "pow")); // Covers pow loop
        assertEquals(0, calc.calculate(10, 5, "invalid")); // Covers default branch
    }
}
