package example.command;

import example.repository.History;

public class Undo {

    public boolean undo(History history) {
        return history.undo();
    }
}
