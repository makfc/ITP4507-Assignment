package Command;

import java.util.Stack;

public class DisplayUndoRedoListCommand implements Command{
    Stack<Command> undoList = new Stack<>();
    Stack<Command> redoList = new Stack<>();

    public DisplayUndoRedoListCommand(Stack<Command> undoList, Stack<Command> redoList) {
        this.undoList = undoList;
        this.redoList = redoList;
    }

    @Override
    public void execute() {
        System.out.println();
    }
}
