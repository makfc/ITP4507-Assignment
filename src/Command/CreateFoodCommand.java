package Command;

import Memento.Caretaker;
import Stock.FoodItem;

import java.util.Vector;

public abstract class CreateFoodCommand implements Command{
    protected FoodItem foodItem;
    protected Vector<FoodItem> foodItems;
    protected Caretaker caretaker;
    protected int itemID;
    protected String name;

    public CreateFoodCommand(Vector<FoodItem> foodItems, Caretaker caretaker, int itemID, String name) {
        this.foodItems = foodItems;
        this.caretaker = caretaker;
        this.itemID = itemID;
        this.name = name;
    }

    @Override
    public abstract void execute();

    @Override
    public String toString() {
        return "Create ID: " + foodItem.getItemID() +
                " Name: " + foodItem.getName();
    }
}
