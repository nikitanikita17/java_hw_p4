package lab24;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RestaurantOrder implements Order {
    private List<Item> items;

    public RestaurantOrder() {
        this.items = new ArrayList<Item>();
    }

    @Override
    public boolean addItem(Item item) {
        return items.add(item);
    }

    @Override
    public boolean removeItemByName(String itemName) {
        boolean removed = false;
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                items.remove(item);
                removed = true;
                break;
            }
        }
        return removed;
    }

    @Override
    public int removeAllByName(String itemName) {
        int count = 0;
        for (int i = items.size() - 1; i >= 0; i--) {
            Item item = items.get(i);
            if (item.getName().equals(itemName)) {
                items.remove(i);
                count++;
            }
        }
        return count;
    }

    @Override
    public int getTotalItemsCount() {
        return items.size();
    }

    @Override
    public Item[] getOrderItems() {
        return items.toArray(new Item[0]);
    }

    @Override
    public int getTotalCost() {
        int totalCost = 0;
        for (Item item : items) {
            totalCost += item.getCost();
        }
        return totalCost;
    }

    @Override
    public int getOrderedItemCount(String itemName) {
        int count = 0;
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String[] getOrderedItemNames() {
        List<String> itemNames = new ArrayList<>();
        for (Item item : items) {
            if (!itemNames.contains(item.getName())) {
                itemNames.add(item.getName());
            }
        }
        return itemNames.toArray(new String[0]);
    }

    @Override
    public Item[] getSortedOrderItems() {
        Item[] sortedItems = items.toArray(new Item[0]);
        Arrays.sort(sortedItems, Comparator.comparingInt(Item::getCost).reversed());
        return sortedItems;
    }
}
