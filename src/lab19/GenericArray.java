package lab19;

public class GenericArray<T> {
    private T[] array;

    public GenericArray(int size) {
        array = (T[]) new Object[size];
    }

    public void setElement(int index, T element) {
        array[index] = element;
    }

    public T getElement(int index) {
        return array[index];
    }

    public int getSize() {
        return array.length;
    }

    public static void main(String[] args) {
        GenericArray<Integer> intArray = new GenericArray<>(5);

        intArray.setElement(0, 10);
        intArray.setElement(1, 20);
        intArray.setElement(2, 30);
        intArray.setElement(3, 40);
        intArray.setElement(4, 50);

        // Getting and printing elements from the array
        for (int i = 0; i < intArray.getSize(); i++) {
            System.out.println("Element at index " + i + ": " + intArray.getElement(i));
        }

        GenericArray<String> stringArray = new GenericArray<>(3);

        // Setting elements in the array
        stringArray.setElement(0, "Hello");
        stringArray.setElement(1, "World");
        stringArray.setElement(2, "!");

        // Getting and printing elements from the array
        for (int i = 0; i < stringArray.getSize(); i++) {
            System.out.println("Element at index " + i + ": " + stringArray.getElement(i));
        }
    }
}
