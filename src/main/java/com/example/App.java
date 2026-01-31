package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.java.com.example.Calculator;
import main.java.com.example.UserService;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        logger.info("Result: {}", calc.calculate(10, 5, "add-again"));
        UserService service = new UserService();
        service.findUser("admin");
        service.deleteUser("admin"); // NEW dangerous call
    }

}
