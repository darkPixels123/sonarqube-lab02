package com.example;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int result = calc.calculate(10, 5, "add");
        LOGGER.log(Level.INFO, "Calculation result: {0}", result);

        try {
            UserService service = new UserService();
            boolean exists = service.userExists("admin");
            LOGGER.log(Level.INFO, "User exists: {0}", exists);
        } catch (IllegalStateException ex) {
            LOGGER.log(Level.WARNING, "Database environment variables not set: {0}", ex.getMessage());
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Database operation failed", ex);
        }
    }
}
