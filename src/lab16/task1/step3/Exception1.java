package lab16.task1.step3;

public class Exception1 {
    public void exceptionDemo() {
        try{
            System.out.println( 2/0 );
        } catch ( ArithmeticException e ) {
            System.out.println("Attempted division by zero");
        }
    }

    public static void main(String[] args) {
        Exception1 exceptionInstance = new Exception1();

        exceptionInstance.exceptionDemo();
    }
}

