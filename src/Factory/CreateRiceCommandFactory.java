package Factory;

import Command.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateRiceCommandFactory extends CreateFoodCommandFactory {
    private String type;

    @Override
    public Command create() {
        Command command = null;

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        System.out.println("Enter id, name and type:");
        try {
            String line = br.readLine();
            String[] record = line.split(",");
            for (int i = 0; i < record.length; i++) {
                record[i] = record[i].trim();
            }
            itemID = Integer.parseInt(record[0]);
            name = record[1];
            type = record[2];
            command = new CreateRiceCommand(foodItems, itemID, name, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return command;
    }
}
