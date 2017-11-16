package Command;

import Caretaker.Caretaker;
import Stock.FoodItem;
import Stock.Rice;

import java.util.Vector;

public class CreateRiceCommand extends CreateFoodCommand {
    private String type;

    public CreateRiceCommand(Vector<FoodItem> foodItems, Caretaker caretaker, int itemID, String name, String type) {
        super(foodItems, caretaker, itemID, name);
        this.type = type;
    }

    @Override
    public void execute() {
        foodItem = new Rice(itemID, name, type);
        foodItems.add(foodItem);
        caretaker.saveFoodItemAndCommand(foodItem, this);
        System.out.println("New item record created.");
    }


}
