package com.example;

public class Calculator {

    public int calculate(int a, int b, String op) {
        if (op == null || op.isBlank()) {
            throw new IllegalArgumentException("Operation must be provided");
        }

        return switch (op) {
            case "add" ->
                a + b;
            case "sub" ->
                a - b;
            case "mul" ->
                a * b;
            case "div" -> {
                if (b == 0) {
                    throw new IllegalArgumentException("Division by zero");
                }
                yield a / b;
            }
            case "mod" -> {
                if (b == 0) {
                    throw new IllegalArgumentException("Modulo by zero");
                }
                yield a % b;
            }
            case "pow" -> {
                if (b < 0) {
                    throw new IllegalArgumentException("Negative exponent is not supported");
                }
                yield (int) Math.pow(a, b);
            }
            default ->
                throw new IllegalArgumentException("Unknown operation: " + op);
        };
    }

    public int add(int x, int y) {
        return x + y;
    }
}
