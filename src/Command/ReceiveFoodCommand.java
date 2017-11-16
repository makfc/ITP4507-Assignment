package Command;

import Caretaker.Caretaker;
import Stock.FoodItem;

public class ReceiveFoodCommand implements Command {
    private Caretaker caretaker;
    private FoodItem foodItem;
    private int quantity;

    public ReceiveFoodCommand(Caretaker caretaker, FoodItem foodItem, int quantity) {
        this.caretaker = caretaker;
        this.foodItem = foodItem;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        caretaker.saveCurrentState(foodItem, this);
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
