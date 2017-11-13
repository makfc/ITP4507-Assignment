package Factory;

import Command.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CreateFoodCommandFactory extends CommandFactory {
    protected int itemID;
    protected String name;

    @Override
    public Command create() {
        Command command = null;
        HashMap<String, String> foodFactoryMap = new HashMap<String, String>(){{
            put("ri","CreateRiceCommandFactory");
            put("in","CreateInstantNoodleCommandFactory");
        }};

        try {
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            System.out.println("Enter food type (ri=rice/in=instant noodle):");
            String line = br.readLine();
            CreateFoodCommandFactory foodCommandFactory =
                    (CreateFoodCommandFactory) Class.forName(
                    "Factory."+ ((String)foodFactoryMap.get(line))
            ).newInstance();
            command = foodCommandFactory.create();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return command;
    }
}
