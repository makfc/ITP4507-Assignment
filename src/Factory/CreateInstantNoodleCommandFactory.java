package Factory;

import Command.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateInstantNoodleCommandFactory extends CreateFoodCommandFactory {
    private int weight;

    @Override
    public Command create() {
        Command command = null;

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        System.out.println("Enter id, name and weight:");
        try {
            String line = br.readLine();
            String[] record = line.split(",");
            for (int i = 0; i < record.length; i++) {
                record[i] = record[i].trim();
            }
            itemID = Integer.parseInt(record[0]);
            name = record[1];
            weight = Integer.parseInt(record[2]);
            command = new CreateInstantNoodleCommand(foodItems, itemID, name, weight);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return command;
    }
}
