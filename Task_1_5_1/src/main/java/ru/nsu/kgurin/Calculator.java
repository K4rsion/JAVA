package ru.nsu.kgurin;

import java.util.List;
import java.util.Stack;

/**
 * Class to define a logic of calculator.
 */
public class Calculator {

    List<String> expression;
    Stack<Double> result = new Stack<>();

    /**
     * Constructor for calculator.
     *
     * @param input expression to calculate
     */
    public Calculator(List<String> input) {
        expression = input;
    }

    /**
     * Method to calculate an expression.
     *
     * @return result of calculation
     * @throws Exception exception in exceptional situations
     */
    public Double calculate() throws Exception {

        for (int i = expression.size() - 1; i >= 0; i--) {

            //for numbers
            boolean numeric = true;
            double num = 0;
            try {
                num = Double.parseDouble(expression.get(i));
            } catch (NumberFormatException e) {
                numeric = false;
            }
            if (numeric) {
                result.add(num);
            }

            //for operations and functions
            else {
                double a = result.pop();
                double b;
                switch (expression.get(i)) {
                    case ("+"):
                        b = result.pop();
                        a += b;
                        result.add(a);
                        break;
                    case ("-"):
                        b = result.pop();
                        a -= b;
                        result.add(a);
                        break;
                    case ("*"):
                        b = result.pop();
                        a *= b;
                        result.add(a);
                        break;
                    case ("/"):
                        b = result.pop();
                        if (b == 0) {
                            throw new Exception("The zero division is not defined");
                        }
                        a /= b;
                        result.add(a);
                        break;
                    case ("pow"):
                        b = result.pop();
                        a = Math.pow(a, b);
                        result.add(a);
                        break;
                    case ("log"):
                        if (a == 0) {
                            throw new Exception("The logarithm of zero is not defined");
                        }
                        a = Math.log(a);
                        result.add(a);
                        break;
                    case ("sqrt"):
                        if (a < 0) {
                            throw new Exception("The sqrt of negative number is not defined");
                        }
                        a = Math.sqrt(a);
                        result.add(a);
                        break;
                    case ("sin"):
                        a = Math.sin(a);
                        result.add(a);
                        break;
                    case ("cos"):
                        a = Math.cos(a);
                        result.add(a);
                        break;
                }
            }
        }
        return result.pop();
    }
}
