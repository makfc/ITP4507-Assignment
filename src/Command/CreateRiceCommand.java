package Command;

import Memento.Caretaker;
import Stock.FoodItem;
import Stock.Rice;

import java.util.Vector;

public class CreateRiceCommand implements Command {
    private FoodItem foodItem;
    private Vector<FoodItem> foodItems;
    private Caretaker caretaker;
    private int itemID;
    private String name;
    private String type;

    public CreateRiceCommand(Vector<FoodItem> foodItems, Caretaker caretaker, int itemID, String name, String type) {
        this.foodItems = foodItems;
        this.caretaker = caretaker;
        this.itemID = itemID;
        this.name = name;
        this.type = type;
    }

    @Override
    public void execute() {
        foodItem = new Rice(itemID, name, type);
        foodItems.add(foodItem);
        caretaker.saveFoodItem(foodItem);
        System.out.println("New item record created.");
    }

}
