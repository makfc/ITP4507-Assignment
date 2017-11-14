package Command;

import Memento.Caretaker;
import Stock.FoodItem;
import Stock.InstantNoodle;

import java.util.Vector;

public class CreateInstantNoodleCommand implements Command {
    private FoodItem foodItem;
    private Vector<FoodItem> foodItems;
    private Caretaker caretaker;
    private int itemID;
    private String name;
    private int weight;

    public CreateInstantNoodleCommand(Vector<FoodItem> foodItems, Caretaker caretaker, int itemID, String name, int weight) {
        this.foodItems = foodItems;
        this.caretaker = caretaker;
        this.itemID = itemID;
        this.name = name;
        this.weight = weight;
    }

    @Override
    public void execute() {
        foodItem = new InstantNoodle(itemID, name, weight);
        foodItems.add(foodItem);
        caretaker.saveFoodItem(foodItem);
        System.out.println("New item record created.");
    }

}
