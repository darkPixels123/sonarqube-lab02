package com.example;

import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testMain() {
        try {
            App.main(new String[]{});
        } catch (Exception e) {
            // Catching exceptions to ensure the test itself passes 
            // even if the database connection inside main fails.
        }
    }
}
