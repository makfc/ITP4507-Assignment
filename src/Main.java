import Command.*;
import Factory.CommandFactory;
import Memento.*;
import Stock.FoodItem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Vector;


public class Main {
    public static void main(String[] args) {
        Vector<FoodItem> foodItems = new Vector<>();
        Caretaker caretaker = new Caretaker();
        caretaker.setFoodItems(foodItems);

        // for test
        Vector<Command> commands = new Vector<>();
        commands.add(new CreateRiceCommand(foodItems, caretaker,
                1010, "Thailand Premium Rice", "brown"));
        commands.add(new CreateInstantNoodleCommand(foodItems, caretaker,
                2010, "Quick Noodle", 100));
        commands.forEach(command -> {
            command.execute();
        });


        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        Command c;
        HashMap<String, String> factoryMap = new HashMap<String, String>() {{
            put("c", "CreateFoodCommandFactory");
            put("s", "ShowFoodCommandFactory");
            put("g", "ReceiveFoodCommandFactory");
            put("d", "DistributeFoodCommandFactory");
            put("u", "UndoCommandFactory");
            put("r", "RedoCommandFactory");
            put("l", "ListUndoRedoCommandFactory");
        }};

        while (true) {
            try {
                System.out.println("Advanced Inventory Management System\n" +
                        "Please enter command: [c | s | g | d | u | r | l | x]\n" +
                        "c = create item, s = show item, g = receive item, d = distribute item,\n" +
                        "u = undo, r = redo, l = list undo/redo, x = exit system\n");
                String option = br.readLine();
                String factoryName = factoryMap.get(option);
                if (factoryName != null) {
                    CommandFactory commandFactory = (CommandFactory) Class.forName("Factory." + factoryName).newInstance();
                    commandFactory.setFoodItems(foodItems);
                    commandFactory.setCaretaker(caretaker);
                    c = commandFactory.create();
                    if (c != null) {
                        c.execute();
                    }
                } else if (option.equals("x")) {
                    System.out.println("Leaving System...");
                    System.exit(0);
                } else {
                    throw new Exception("Invalid Option");
                }
            } catch (Exception e) {
                System.out.println("*** " + e.getMessage());
            }
            System.out.println();
        }
    }
}
