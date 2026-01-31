package main.java.com.example; // Corrected package name

public class Calculator {

    public int calculate(int a, int b, String op) {
        return switch (op) {
            case "add", "add-again" ->
                a + b;
            case "sub", "sub-again" ->
                a - b;
            case "mul" ->
                a * b;
            case "div" ->
                (b == 0) ? 0 : a / b;
            default ->
                0;
        };
    }
}
