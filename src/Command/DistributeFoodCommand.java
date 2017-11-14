package Command;

import Stock.FoodItem;

public class DistributeFoodCommand implements Command {
    private FoodItem foodItem;
    private int quantity;

    public DistributeFoodCommand(FoodItem foodItem, int quantity) {
        this.foodItem = foodItem;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        foodItem.setBalance(foodItem.getBalance() - quantity);
        System.out.println("Distributed " + quantity +
                " packs of " + foodItem.getName() +
                ". Current quantity is " +
                foodItem.getBalance() + ".");
    }

    @Override
    public String toString() {
        return "Distribute " + quantity +
                " packs."+
                " ID: " + foodItem.getItemID() +
                " Name: " + foodItem.getName();
    }
}
