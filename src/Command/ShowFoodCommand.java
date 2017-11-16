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
                String[] foodFieldAndValueStr =
                        foodItem.toString().split("\n");
                String id = getFoodItemValue(foodFieldAndValueStr[0]);
                String name = getFoodItemValue(foodFieldAndValueStr[1]);
                String quantity = getFoodItemValue(foodFieldAndValueStr[2]);
                String otherInfo = getFoodItemValue(foodFieldAndValueStr[3]);
                String otherInfoFieldName = getFoodItemFieldName(foodFieldAndValueStr[3]);

                System.out.printf(tableFormat, id, name, quantity,
                        otherInfoFieldName + ": " +otherInfo);
            }
        } else {
            try {
                int itemID = Integer.parseInt(inputID);
                FoodItem foodItem = FoodItemsUtil.getFoodItemByID(foodItems, itemID);

                // error checking
                if (foodItem == null){
                    System.out.println("Food item with specified ID not found!");
                    return;
                }

                System.out.println("Food item information");
                System.out.println(foodItem);
            } catch (NumberFormatException e){
                System.out.println("Invalid ID!");
            }
        }
    }

    private String getFoodItemValue(String fieldAndValueStr){
        return fieldAndValueStr.split(": ")[1];
    }

    private String getFoodItemFieldName(String fieldAndValueStr){
        return fieldAndValueStr.split(": ")[0];
    }
}
