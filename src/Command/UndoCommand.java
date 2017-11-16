package Command;

import Caretaker.Caretaker;

public class UndoCommand implements Command {
    private Caretaker caretaker;

    public UndoCommand(Caretaker caretaker) {
        this.caretaker = caretaker;
    }

    @Override
    public void execute() {
        caretaker.undo();
    }
}
