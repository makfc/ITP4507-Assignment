package Command;

import Stock.FoodItem;
import Stock.FoodItemsUtil;

import java.util.Vector;

public class ShowFoodCommand implements Command {
    private Vector<FoodItem> foodItems;
    private String inputID;

    public ShowFoodCommand(Vector<FoodItem> foodItems, String inputID) {
        this.foodItems = foodItems;
        this.inputID = inputID;
    }

    @Override
    public void execute() {
        if (inputID.equals("*")) {
            System.out.println("Food item information");
            final String tableFormat = "%-10s%-30s%-15s%s\n";
            System.out.printf(tableFormat,
                    "ID", "Name", "Quantity", "Other Info");

            for (FoodItem foodItem: foodItems) {

                // parse the foodItem.toString() format
                String[] foodItemFieldValueStr =
                        foodItem.toString().split("\n");
                String id = getFoodItemFieldValue(foodItemFieldValueStr[0]);
                String name = getFoodItemFieldValue(foodItemFieldValueStr[1]);
                String quantity = getFoodItemFieldValue(foodItemFieldValueStr[2]);
                String otherInfo = getFoodItemFieldValue(foodItemFieldValueStr[3]);
                String otherInfoFieldName = getFoodItemFieldName(foodItemFieldValueStr[3]);

                System.out.printf(tableFormat, id, name, quantity,
                        otherInfoFieldName + ": " +otherInfo);
            }
        } else {
            try {
                int itemID = Integer.parseInt(inputID);
                FoodItem foodItem = FoodItemsUtil.getFoodItemByID(foodItems, itemID);
                if (foodItem != null) {
                    System.out.println("Food item information");
                    System.out.println(foodItem);
                    return;
                }
            } catch (NumberFormatException ignored){ }
            System.out.println("Food item with specified ID not found!");
        }
    }

    private String getFoodItemFieldValue(String data){
        return data.split(": ")[1];
    }

    private String getFoodItemFieldName(String data){
        return data.split(": ")[0];
    }
}
