package lab24;

public class RestaurantOrderTest {
    public static void main(String[] args) {
        RestaurantOrder order = new RestaurantOrder();

        // Create some items
        Drink drink1 = new Drink(5, "Cola", "Refreshing drink");
        Drink drink2 = new Drink(3, "Orange Juice", "Freshly squeezed juice");
        Dish dish1 = new Dish(10, "Pasta", "Italian pasta dish");
        Dish dish2 = new Dish(8, "Salad", "Fresh garden salad");

        // Add items to the order
        order.addItem(drink1);
        order.addItem(drink2);
        order.addItem(dish1);
        order.addItem(dish2);
        order.addItem(dish1); // Add the same dish again

        // Display order details
        System.out.println("Total items in the order: " + order.getTotalItemsCount());
        System.out.println("Total cost of the order: " + order.getTotalCost());

        // Remove an item by name
        boolean removed = order.removeItemByName("Cola");
        if (removed) {
            System.out.println("Cola removed from the order");
        } else {
            System.out.println("Cola not found in the order");
        }

        // Remove all items with a specific name
        int count = order.removeAllByName("Pasta");
        System.out.println("Removed " + count + " Pasta(s) from the order");

        // Get ordered item names
        String[] orderedItemNames = order.getOrderedItemNames();
        System.out.println("Ordered Item Names:");
        for (String name : orderedItemNames) {
            System.out.println("- " + name);
        }

        // Get sorted order items by cost (descending)
        Item[] sortedItems = order.getSortedOrderItems();
        System.out.println("Sorted Order Items (by cost, descending):");
        for (Item item : sortedItems) {
            System.out.println("- " + item.getName() + ": $" + item.getCost());
        }
    }
}
