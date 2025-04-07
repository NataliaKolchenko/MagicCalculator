package example.command;

import example.repository.History;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class UndoTest {

    @Test
    void testUndo_Success() {
        History history = new History();
        Undo undo = new Undo();

        history.saveValue(1); // first number
        history.saveValue(2); // increment
        history.saveValue(4); // double

        int result = undo.undo(history);

        assertEquals(2, result);

    }

    @Test
    void testUndo_Exception() {
        History history = new History();
        Undo undo = new Undo();

        assertThrows(EmptyStackException.class, () -> undo.undo(history));
    }

    @Test
    void testUndo_SingleNumber_Success() {
        History history = new History();
        Undo undo = new Undo();

        history.saveValue(1); // first number

        int result = undo.undo(history);

        assertEquals(1, result);
    }
}