package Factory;

import Command.*;

public class RedoCommandFactory extends CommandFactory {
    @Override
    public Command create() throws Exception {
        return new RedoCommand(caretaker);
    }
}
