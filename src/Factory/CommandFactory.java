package Factory;

import Stock.FoodItem;
import Command.*;

import java.util.Stack;
import java.util.Vector;

public abstract class CommandFactory {
    Vector<FoodItem> foodItems;
    Stack<Command> undoList = new Stack<>();
    Stack<Command> redoList = new Stack<>();

    public abstract Command create() throws Exception;

    public void setFoodItems(Vector<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }
}
