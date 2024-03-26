package lab23;

public final class Drink {
    private final int cost;
    private final String name;
    private final String description;

    private static final int DEFAULT_COST = 0;

    public Drink(String name, String description) {
        this(DEFAULT_COST, name, description);
    }

    public Drink(int cost, String name, String description) {
        this.cost = cost;
        this.name = name;
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
