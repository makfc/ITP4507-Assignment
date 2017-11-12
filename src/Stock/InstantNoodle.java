package Stock;

public class InstantNoodle extends FoodItem {
    private int weight;

    public InstantNoodle(int itemID, String name, int weight) {
        super(itemID, name);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "InstantNoodle{" +
                "itemID=" + getItemID() +
                ", name='" + getName() + '\'' +
                ", balance=" + getBalance() +
                ", weight=" + weight +
                '}';
    }
}
