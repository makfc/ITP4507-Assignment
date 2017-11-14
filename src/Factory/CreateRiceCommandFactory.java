package Factory;

import Command.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CreateRiceCommandFactory extends CreateFoodCommandFactory {
    @Override
    public Command create() throws Exception {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        System.out.println("Enter id, name and type:");

        String line = br.readLine();

        // remove any leading and trailing whitespace
        String[] record = line.split(",");
        for (int i = 0; i < record.length; i++) {
            record[i] = record[i].trim();
        }
        itemID = Integer.parseInt(record[0]);
        name = record[1];
        String type = record[2];
        return new CreateRiceCommand(foodItems, itemID, name, type);
    }
}
