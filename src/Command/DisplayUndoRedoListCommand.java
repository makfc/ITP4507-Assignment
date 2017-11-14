package Command;

import java.util.Stack;

public class DisplayUndoRedoListCommand implements Command{
    private Stack<Command> undoList = new Stack<>();
    private Stack<Command> redoList = new Stack<>();

    public DisplayUndoRedoListCommand(Stack<Command> undoList, Stack<Command> redoList) {
        this.undoList = undoList;
        this.redoList = redoList;
    }

    @Override
    public void execute() {
        System.out.println("Undo List:");
        if (undoList.empty()){
            System.out.println("Empty");
        } else {
            undoList.forEach(System.out::println);
        }

        System.out.println();

        System.out.println("Redo List:");
        if (redoList.empty()){
            System.out.println("Empty");
        } else {
            redoList.forEach(System.out::println);
        }
    }
}
