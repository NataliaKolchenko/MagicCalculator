package example.command;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecrementTest {

    @Test
    void testDecrement() {
        int receivedNumber = 5;
        Decrement dec = new Decrement();
        int result = dec.decrement(receivedNumber);

        assertEquals(4, result);
    }
}