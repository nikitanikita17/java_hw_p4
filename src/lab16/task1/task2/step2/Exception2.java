package lab16.task1.task2.step2;

import lab16.task1.step3.Exception1;

import java.util.Scanner;

public class Exception2 {
    public void exceptionDemo() {
        Scanner myScanner = new Scanner( System.in);
        System.out.print( "Enter an integer ");
        String intString = myScanner.next();
        int i = Integer.parseInt(intString);
        System.out.println( 2/i );
    }

    public static void main(String[] args) {
        Exception2 exceptionInstance = new Exception2();

        exceptionInstance.exceptionDemo();
    }
}
