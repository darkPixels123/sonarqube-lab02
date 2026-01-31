package main.java.com.example;

public class Calculator {

    // Code Smell: Long method + high complexity
    // EVEN WORSE: longer, more complex, duplicated logic
    public int calculate(int a, int b, String op) {
        switch (op) {
            case "add", "add-again":
                return a + b;
            case "sub", "sub-again":
                return a - b;
            case "mul":
                return a * b;
            case "div":
                if (b == 0) {
                    return 0;
                } else {
                    return a / b;
                }
            case "mod":
                return a % b;
            case "pow":
                int result = 1;
                for (int i = 0; i < b; i++) {
                    result = result * a;
                }
                return result;
            default:
                return 0;
        }
    }

    // Code Duplication (students must remove)
    public int addNumbers(int x, int y) {
        return x + y;
    }

    public int sumValues(int a, int b) {
        return a + b;
    }

    // INTENTIONAL DUPLICATION
    public int addAgain(int a, int b) {
        return a + b;
    }

}
