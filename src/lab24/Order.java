package lab24;


public interface Order {
    boolean addItem(Item item);
    boolean removeItemByName(String itemName);
    int removeAllByName(String itemName);
    int getTotalItemsCount();
    Item[] getOrderItems();
    int getTotalCost();
    int getOrderedItemCount(String itemName);
    String[] getOrderedItemNames();
    Item[] getSortedOrderItems();
}
