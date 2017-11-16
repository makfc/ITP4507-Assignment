package Command;

import Caretaker.Caretaker;
import Stock.FoodItem;
import Stock.InstantNoodle;

import java.util.Vector;

public class CreateInstantNoodleCommand extends CreateFoodCommand {
    private int weight;

    public CreateInstantNoodleCommand(Vector<FoodItem> foodItems, Caretaker caretaker, int itemID, String name, int weight) {
        super(foodItems, caretaker, itemID, name);
        this.weight = weight;
    }

    @Override
    public void execute() {
        foodItem = new InstantNoodle(itemID, name, weight);
        foodItems.add(foodItem);
        caretaker.saveCurrentState(foodItem, this);
        System.out.println("New item record created.");
    }

}
