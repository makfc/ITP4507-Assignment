package Factory;

import Command.*;
import Stock.FoodItem;
import Stock.FoodItemsUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DistributeFoodCommandFactory extends CommandFactory {
    @Override
    public Command create() throws Exception {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        System.out.println("Enter ID:");
        int itemID = Integer.parseInt(br.readLine());
        System.out.println("Quantity to distribute:");
        int quantity = Integer.parseInt(br.readLine());

        FoodItem foodItem = FoodItemsUtil.getFoodItemByID(foodItems, itemID);
        if (foodItem != null) {
            if (foodItem.getBalance() < quantity){
                System.out.println("Invalid quantity (current balance < distributing quantity).");
            } else {
                return new DistributeFoodCommand(caretaker, foodItem, quantity);
            }
        } else {
            System.out.println("Food item with specified ID not found!");
        }
        return null;
    }
}
