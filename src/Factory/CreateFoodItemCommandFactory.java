package Factory;

import Command.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateFoodItemCommandFactory extends CommandFactory {


    @Override
    public Command create() {
        Command command = null;
        try {
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            System.out.println("Enter food type (ri=rice/in=instant noodle):");
            String line = br.readLine();
            String record[];
            switch (line){
                case "ri":
                    System.out.println("Enter id, name and type:");
                    line = br.readLine();
                    record = line.split(",");
                    for (int i = 0; i < record.length ; i++) {
                        record[i] = record[i].trim();
                    }
                    command = new CreateRiceCommand(foodItems,
                           Integer.parseInt(record[0]),record[1],record[2]);
                    break;
                case "in":
                    System.out.println("Enter id, name and weight:");
                    line = br.readLine();
                    record = line.split(",");
                    for (int i = 0; i < record.length ; i++) {
                        record[i] = record[i].trim();
                    }
                    command = new CreateInstantNoodleCommand(foodItems,
                            Integer.parseInt(record[0]),record[1],Integer.parseInt(record[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return command;
    }
}
