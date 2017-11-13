package Command;

import Stock.FoodItem;
import Stock.Rice;

import java.util.Vector;

public class CreateRiceCommand implements Command {
    private FoodItem foodItem;
    private Vector<FoodItem> foodItems;
    private int itemID;
    private String name;
    private String type;

    public CreateRiceCommand(Vector<FoodItem> foodItems, int itemID, String name, String type) {
        this.foodItems = foodItems;
        this.itemID = itemID;
        this.name = name;
        this.type = type;
    }

    @Override
    public void execute() {
        foodItem = new Rice(itemID, name, type);
        foodItems.add(foodItem);
        System.out.println("New item record created.");
    }

}
