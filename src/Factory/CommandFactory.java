package Factory;

import Stock.FoodItem;
import Command.*;

import java.util.Vector;

public abstract class CommandFactory {
    Vector<FoodItem> foodItems;

    public abstract Command create() throws Exception;

    public void setFoodItems(Vector<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }
}
