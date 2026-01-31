package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void testFullBranchCoverage() {
        Calculator calc = new Calculator();
        // Cover all switch cases including aliases
        assertEquals(15, calc.calculate(10, 5, "add"));
        assertEquals(15, calc.calculate(10, 5, "add-again"));
        assertEquals(5, calc.calculate(10, 5, "sub"));
        assertEquals(5, calc.calculate(10, 5, "sub-again"));
        assertEquals(50, calc.calculate(10, 5, "mul"));

        // Cover both branches of the ternary operator (b == 0)
        assertEquals(2, calc.calculate(10, 5, "div"));
        assertEquals(0, calc.calculate(10, 0, "div"));

        // Cover the default branch
        assertEquals(0, calc.calculate(10, 5, "unsupported-op"));
    }
}
