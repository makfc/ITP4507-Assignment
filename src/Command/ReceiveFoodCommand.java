package Command;

import Stock.FoodItem;

public class ReceiveFoodCommand implements Command {
    private FoodItem foodItem;
    private int quantity;

    public ReceiveFoodCommand(FoodItem foodItem, int quantity) {
        this.foodItem = foodItem;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        foodItem.setBalance(foodItem.getBalance() + quantity);
        System.out.println("Received " + quantity +
                " packs of " + foodItem.getName() +
                ". Current quantity is "
                + foodItem.getBalance() + ".");
    }

    @Override
    public String toString() {
        return "Receive " + quantity +
                " packs." +
                " ID: " + foodItem.getItemID() +
                " Name: " + foodItem.getName();
    }
}
