package Factory;

import Command.*;
import Stock.FoodItem;
import Stock.FoodItemsUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReceiveFoodCommandFactory extends CommandFactory {
    @Override
    public Command create() throws Exception {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        System.out.println("Enter ID:");
        int itemID = Integer.parseInt(br.readLine());
        System.out.println("Quantity to receive:");
        int quantity = Integer.parseInt(br.readLine());

        FoodItem foodItem = FoodItemsUtil.getFoodItemByID(foodItems, itemID);

        // error checking
        if (foodItem == null) {
            System.out.println("Food item with specified ID not found!");
            return null;
        }
        if (quantity <= 0) {
            System.out.println("Quantity must greater zero!");
            return null;
        }

        return new ReceiveFoodCommand(caretaker, foodItem, quantity);
    }
}
