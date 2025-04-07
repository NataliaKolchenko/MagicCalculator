package example.repository;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class HistoryTest {

    @Test
    void test_undo_EmptyStack() {
        History history = new History();

        assertThrows(EmptyStackException.class, history::undo);
    }

    @Test
    void test_undo_SingleNumber() {
        History history = new History();
        history.saveValue(1);

        int res = history.undo();

        assertEquals(1, res);
    }

    @Test
    void test_undo_TwoNumbers() {
        History history = new History();
        history.saveValue(1);
        history.saveValue(2);

        int res = history.undo();

        assertEquals(1, res);
    }

    @Test
    void test_undo_SomeNumbers() {
        History history = new History();
        history.saveValue(1);
        history.saveValue(2);
        history.saveValue(3);
        history.saveValue(4);


        int res = history.undo();

        assertEquals(3, res);
    }



    @Test
    void test_getCurrentValue_EmptyStack() {
        History history = new History();
        int res = history.getCurrentValue();

        assertEquals(0, res);
    }

    @Test
    void test_getCurrentValue_SingleNumber() {
        History history = new History();
        history.saveValue(1);

        int res = history.getCurrentValue();

        assertEquals(1, res);
    }

    @Test
    void test_getCurrentValue_SomeNumbers() {
        History history = new History();
        history.saveValue(1);
        history.saveValue(2);

        int res = history.getCurrentValue();

        assertEquals(2, res);
    }




}