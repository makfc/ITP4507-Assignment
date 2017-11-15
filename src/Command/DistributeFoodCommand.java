package Command;

import Memento.Caretaker;
import Stock.FoodItem;

public class DistributeFoodCommand implements Command {
    private Caretaker caretaker;
    private FoodItem foodItem;
    private int quantity;

    public DistributeFoodCommand(Caretaker caretaker, FoodItem foodItem, int quantity) {
        this.caretaker = caretaker;
        this.foodItem = foodItem;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        caretaker.saveFoodItemAndCommand(foodItem, this);
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
