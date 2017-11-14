package Factory;

import Command.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ShowFoodCommandFactory extends CommandFactory {
    @Override
    public Command create() throws Exception {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        System.out.println("Enter ID (* to show all):");

        String inputID = br.readLine();
        return new ShowFoodCommand(foodItems, inputID);
    }
}
