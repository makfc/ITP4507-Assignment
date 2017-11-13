package Command;

public class ShowFoodItemCommand implements Command {


    @Override
    public void execute() {
        System.out.println("Enter ID (* to show all):");

    }
}
