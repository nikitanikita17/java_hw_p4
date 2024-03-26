package lab23;

public class DrinkTest {
    public static void main(String[] args) {
        // Create a Drink object using the constructor with two parameters
        Drink drink1 = new Drink("Coffee", "Aromatic beverage");

        // Get properties of drink1
        System.out.println("Drink 1 - Name: " + drink1.getName());
        System.out.println("Drink 1 - Description: " + drink1.getDescription());
        System.out.println("Drink 1 - Cost: " + drink1.getCost());

        // Create a Drink object using the constructor with three parameters
        Drink drink2 = new Drink(5, "Tea", "Herbal infusion");

        // Get properties of drink2
        System.out.println("\nDrink 2 - Name: " + drink2.getName());
        System.out.println("Drink 2 - Description: " + drink2.getDescription());
        System.out.println("Drink 2 - Cost: " + drink2.getCost());
    }
}

