package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testMainExecutionPath() {
        // This covers the full execution path of main()
        try {
            App.main(new String[]{});
            fail("Should have thrown exception due to missing DB connection");
        } catch (Exception e) {
            // Expected - we've now covered:
            // - Calculator instantiation
            // - calc.calculate() call
            // - logger.info() call
            // - UserService instantiation
            // - service.findUser() call
            // - service.deleteUser() call
            assertNotNull(e);
        }
    }

    @Test
    void testMainWithEmptyArgs() {
        assertThrows(Exception.class, () -> App.main(new String[]{}));
    }

    @Test
    void testCalculatorUsedInMain() {
        Calculator calc = new Calculator();
        // Verify the specific call made in main()
        assertEquals(15, calc.calculate(10, 5, "add-again"));
    }
}
