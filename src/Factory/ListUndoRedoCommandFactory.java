package Factory;

import Command.*;

public class ListUndoRedoCommandFactory extends CommandFactory {
    @Override
    public Command create() throws Exception {
        return new ListUndoRedoCommand(caretaker);
    }
}
