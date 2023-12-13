package lab16.task1.step2;

public class Exception1 {
    public void exceptionDemo() {
        System.out.println(2.0 / 0.0);
    }

    public static void main(String[] args) {
        Exception1 exceptionInstance = new Exception1();

        exceptionInstance.exceptionDemo();
    }
}
