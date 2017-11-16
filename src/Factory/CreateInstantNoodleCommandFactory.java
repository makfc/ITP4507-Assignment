package Factory;

import Command.*;
import Stock.FoodItemsUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CreateInstantNoodleCommandFactory extends CreateFoodCommandFactory {
    @Override
    public Command create() throws Exception {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        System.out.println("Enter id, name and weight:");

        String line = br.readLine();
        String[] record = line.split(",");

        // remove any leading and trailing whitespace
        for (int i = 0; i < record.length; i++) {
            record[i] = record[i].trim();
        }

        itemID = Integer.parseInt(record[0]);
        name = record[1];
        int weight = Integer.parseInt(record[2]);

        // error checking
        if (FoodItemsUtil.getFoodItemByID(foodItems, itemID) != null) {
            System.out.println("ID must not duplicate!");
            return null;
        }
        if (weight <= 0) {
            System.out.println("Weight must greater zero!");
            return null;
        }

        return new CreateInstantNoodleCommand(foodItems, caretaker, itemID, name, weight);
    }
}
