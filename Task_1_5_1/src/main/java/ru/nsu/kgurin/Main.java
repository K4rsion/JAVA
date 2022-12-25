package ru.nsu.kgurin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Main function for input an expression.
 */
public class Main {

    /**
     * Main static method to start calculator.
     */
    public static void main(String[] args) throws IOException {
        System.out.println("CALCULATOR");
        System.out.println("Use Q to exit.");

        BufferedReader input = new BufferedReader(
                new InputStreamReader(System.in));

        while (true) {
            System.out.print("Enter your expression: ");
            List<String> expression = List.of(input.readLine().split(" "));
            if (expression.get(0).equals("Q")) {
                break;
            }
            try {
                var calc = new Calculator(expression);
                double result = calc.calculate();
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        input.close();
    }
}
