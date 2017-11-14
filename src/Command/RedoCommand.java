package Command;

import Memento.Caretaker;

public class RedoCommand implements Command {
    private Caretaker caretaker;

    public RedoCommand(Caretaker caretaker) {
        this.caretaker = caretaker;
    }

    @Override
    public void execute() {
        caretaker.redo();
    }
}
