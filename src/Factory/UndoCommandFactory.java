package Factory;

import Command.*;

public class UndoCommandFactory extends CommandFactory {
    @Override
    public Command create() throws Exception {
        return new UndoCommand(caretaker);
    }
}
