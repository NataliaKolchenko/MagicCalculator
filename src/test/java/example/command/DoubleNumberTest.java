package example.command;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DoubleNumberTest {

    @Test
    void testDoubleNumber_PositiveNumber() {
        int receivedNumber = 2;
        DoubleNumber doubleNumberN = new DoubleNumber();
        int result = doubleNumberN.doubleNumber(receivedNumber);

        assertEquals(4, result);
    }

    @Test
    void testDoubleNumber_NegativeNumber() {
        int receivedNumber = -2;
        DoubleNumber doubleNumberN = new DoubleNumber();
        int result = doubleNumberN.doubleNumber(receivedNumber);

        assertEquals(-4, result);
    }

    @Test
    void testDoubleNumber_Zero() {
        int receivedNumber = 0;
        DoubleNumber doubleNumberN = new DoubleNumber();
        int result = doubleNumberN.doubleNumber(receivedNumber);

        assertEquals(0, result);
    }
}