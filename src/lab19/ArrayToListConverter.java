package lab19;

import java.util.ArrayList;
import java.util.List;

public class ArrayToListConverter {
    public static List<Object> convertArrayToList(Object[] array) {
        List<Object> list = new ArrayList<>();

        for (Object element : array) {
            list.add(element);
        }

        return list;
    }

    public static void main(String[] args) {
        // Example array of strings/numbers
        String[] stringArray = {"Apple", "Orange", "Banana"};
        Integer[] intArray = {1, 2, 3, 4, 5};

        // Convert arrays to lists
        List<Object> stringList = convertArrayToList(stringArray);
        List<Object> intList = convertArrayToList(intArray);

        // Display converted lists
        System.out.println("String List: " + stringList);
        System.out.println("Integer List: " + intList);
    }
}
