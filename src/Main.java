import Factory.CommandFactory;
import Stock.FoodItem;
import Command.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Vector;


public class Main {

    public static void main(String[] args) {
        Vector<FoodItem> foodItems = new Vector<>();
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        Command c;
//        String[] factory = {
//                "DrawCommandFactory",
//                "DeleteCommandFactory",
//                "CreateCircleCommandFactory",
//                "CreateRectangleCommandFactory"
//        };
        HashMap<String, String> factoryMap = new HashMap<String, String>(){{
            put("c","CreateFoodItemCommandFactory");
            put("","");
            put("","");
            put("","");
            put("","");
            put("","");
            put("","");
        }};

        while (true) {
            try {
                System.out.println(
                        "Advanced Inventory Management System\n" +
                        "Please enter command: [c | s | g | d | u | r | l | x]\n" +
                        "c = create item, s = show item, g = receive item, d = distribute item,\n" +
                        "u = undo, r = redo, l = list undo/redo, x = exit system\n");
                String option = br.readLine();
                switch (option) {
                    case "c":
                    case "s":
                    case "g":
                    case "d":
                        CommandFactory commandFactory = (CommandFactory)
                                Class.forName(
                                        "Factory."+
                                                ((String)factoryMap.get(option))
                                ).newInstance();
                        commandFactory.setFoodItems(foodItems);
                        c = commandFactory.create();
                        c.execute();
//                        if (!(c instanceof DrawCommand)) {
//                            history.push(c);
//                        }
                        break;
/*                    case 0:
                        System.out.println("-- End --");
                        System.exit(0);
                    case 1:
                        c = history.pop();
                        c.undo();
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        CommandFactory commandFactory = (CommandFactory)
                                Class.forName(
                                        Main.class.getPackage().getName()+"."+
                                                factory[option-2]).newInstance();
                        commandFactory.setShapes(shapes);
                        c = commandFactory.create();
                        c.execute();
                        if (!(c instanceof DrawCommand)) {
                            history.push(c);
                        }
                        break;*/
                    default:
                        throw new Exception("Invalid Option");
                }
            } catch (Exception e) {
                System.out.println("*** " + e.getMessage());
            }
            System.out.println();
        }
    }
}
