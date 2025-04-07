package example.command;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IncrementTest {

    @Test
    void increment() {
        int receivedNumber = 5;
        Increment inc = new Increment();
        int result = inc.increment(receivedNumber);

        assertEquals(6, result);
    }
}