package Stock;

import java.util.Vector;

public class FoodItemsUtil {
    public static FoodItem getFoodItemByID(Vector<FoodItem> foodItems, int itemID){
        for (FoodItem foodItem : foodItems) {
            if (foodItem.getItemID() == itemID) {
                return foodItem;
            }
        }
        return null;
    }
}
