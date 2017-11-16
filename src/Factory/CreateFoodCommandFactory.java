package Factory;

import Command.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CreateFoodCommandFactory extends CommandFactory {
    protected int itemID;
    protected String name;

    @Override
    public Command create() throws Exception {
        HashMap<String, String> foodFactoryMap = new HashMap<String, String>() {{
            put("ri", "CreateRiceCommandFactory");
            put("in", "CreateInstantNoodleCommandFactory");
        }};

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        System.out.println("Enter food type (ri=rice/in=instant noodle):");
        String line = br.readLine();

        // get the factoryName from the HashMap
        String factoryName = foodFactoryMap.get(line);

        // error checking
        // if the option is not in the HashMap
        if (factoryName == null) {
            System.out.println("Invalid Option");
            return null;
        }

        // then call the corresponding factory
        CreateFoodCommandFactory foodCommandFactory = (CreateFoodCommandFactory)
                Class.forName("Factory." +
                        factoryName
                ).newInstance();
        foodCommandFactory.setFoodItems(foodItems);
        foodCommandFactory.setCaretaker(caretaker);

        return foodCommandFactory.create();
    }
}
