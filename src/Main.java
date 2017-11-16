import Caretaker.Caretaker;
import Command.*;
import Factory.CommandFactory;
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
                System.out.println("Advanced Inventory Management System\n" + "Please enter command: [c | s | g | d | u | r | l | x]\n" + "c = create item, s = show item, g = receive item, d = distribute item,\n" + "u = undo, r = redo, l = list undo/redo, x = exit system\n");
                String option = br.readLine();

                // get the factoryName from the HashMap
                String factoryName = factoryMap.get(option);

                // if the option is in the HashMap,
                // then call the corresponding factory
                if (factoryName != null) {

                    // create the corresponding factory
                    CommandFactory commandFactory = (CommandFactory) Class.forName("Factory." + factoryName).newInstance();

                    commandFactory.setFoodItems(foodItems);
                    commandFactory.setCaretaker(caretaker);

                    // create the command
                    c = commandFactory.create();

                    // if no error occur
                    if (c != null) {
                        c.execute();
                    }
                } else if (option.equals("x")) {
                    System.out.println("Leaving System...");
                    System.exit(0);
                } else {
                    throw new Exception("Invalid Option");
                }
            } catch (NumberFormatException e){
                System.out.println("Only number accepted!");
            } catch (Exception e) {
                System.out.println("*** " + e.getMessage());
            }
            System.out.println();
        }
    }
}
