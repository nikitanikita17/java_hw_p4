package lab18;
public class ThreeVariables<T, V, K> {
    private T variable1;
    private V variable2;
    private K variable3;

    public ThreeVariables(T variable1, V variable2, K variable3) {
        this.variable1 = variable1;
        this.variable2 = variable2;
        this.variable3 = variable3;
    }

    public T getVariable1() {
        return variable1;
    }

    public V getVariable2() {
        return variable2;
    }

    public K getVariable3() {
        return variable3;
    }

    public void displayClassNames() {
        System.out.println("Class of variable1: " + variable1.getClass().getSimpleName());
        System.out.println("Class of variable2: " + variable2.getClass().getSimpleName());
        System.out.println("Class of variable3: " + variable3.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        // Example usage
        String str = "Hello";
        Integer num = 123;
        Double dbl = 4.56;

        ThreeVariables<String, Integer, Double> instance = new ThreeVariables<>(str, num, dbl);
        instance.displayClassNames();
    }
}
