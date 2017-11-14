package Factory;

import Command.*;

public class DisplayUndoRedoListCommandFactory extends CommandFactory {
    @Override
    public Command create() throws Exception {
        return new DisplayUndoRedoListCommand();
    }
}
