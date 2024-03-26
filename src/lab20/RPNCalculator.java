package lab20;

import java.util.Stack;

public class RPNCalculator {

    public static double evaluateRPN(String[] tokens) {
        Stack<Double> stack = new Stack<>();

        for (String token : tokens) {
            if (token.matches("-?\\d+(\\.\\d+)?")) { // Check if the token is a number
                stack.push(Double.parseDouble(token));
            } else {
                double operand2 = stack.pop();
                double operand1 = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + token);
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        // Example usage
        String[] expression = {"2", "3", "+", "5", "*"};
        double result = evaluateRPN(expression);
        System.out.println("Result: " + result);
    }
}
