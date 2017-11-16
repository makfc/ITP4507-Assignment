package Factory;

import Caretaker.Caretaker;
import Stock.FoodItem;
import Command.*;

import java.util.Vector;

public abstract class CommandFactory {
    Vector<FoodItem> foodItems;
    Caretaker caretaker;

    public abstract Command create() throws Exception;

    public void setFoodItems(Vector<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    public void setCaretaker(Caretaker caretaker) {
        this.caretaker = caretaker;
    }
}
