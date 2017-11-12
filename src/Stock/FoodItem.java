package Stock;

public class FoodItem {
    private int itemID;
    private String name;
    private int balance;

    public FoodItem(int itemID, String name) {
        this.itemID = itemID;
        this.name = name;
    }

    public int getItemID() {
        return itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "FoodItem{" + "itemID=" + itemID +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}