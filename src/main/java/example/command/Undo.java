package example.command;

import example.repository.History;

public class Undo {

    public int undo(History history) {
        return history.undo();
    }
}
