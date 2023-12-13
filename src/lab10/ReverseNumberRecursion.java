package lab10;

public class ReverseNumberRecursion {

    // Function to reverse a number using recursion
    public static int reverseNumber(int n) {
        return reverseHelper(n, 0);
    }

    // Recursive helper function to reverse the number
    private static int reverseHelper(int n, int reversed) {
        if (n == 0) {
            return reversed;
        }

        // Extract the last digit from 'n'
        int lastDigit = n % 10;

        // Update the reversed number by adding the last digit
        reversed = reversed * 10 + lastDigit;

        // Recursively call with remaining digits]
        return reverseHelper(n / 10, reversed);
    }

    public static void main(String[] args) {
        int inputNumber = 123456789; // Replace this number with your input

        int reversedNumber = reverseNumber(inputNumber);
        System.out.println("Original Number: " + inputNumber);
        System.out.println("Reversed Number: " + reversedNumber);
    }
}
