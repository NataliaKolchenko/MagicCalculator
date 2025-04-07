package example.controller;

import example.command.*;
import example.repository.History;
import example.utils.Printer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.EmptyStackException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class CalculatorControllerTest {
    @Mock
    private Printer printer;

    @Mock
    private Scanner scanner;

    @Mock
    private History stackNumbers;

    @Mock
    private Undo undo;

    private CalculatorController calculatorController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        calculatorController = new CalculatorController(printer, scanner, stackNumbers);
    }

    @Test
    public void testProcessCommand_Increment() {
        int startNumber= 5;
        int resultNumber = 6;

        when(stackNumbers.getCurrentValue()).thenReturn(startNumber);

        boolean result = calculatorController.processCommand("increment");

        verify(stackNumbers).getCurrentValue();
        verify(printer).print(resultNumber);
        verify(stackNumbers).saveValue(resultNumber);
        assertTrue(result);
    }

    @Test
    public void testProcessCommand_Decrement() {
        int startNumber= 2;
        int resultNumber = 1;

        when(stackNumbers.getCurrentValue()).thenReturn(startNumber);

        boolean result = calculatorController.processCommand("decrement");

        verify(stackNumbers).getCurrentValue();
        verify(printer).print(resultNumber);
        verify(stackNumbers).saveValue(resultNumber);
        assertTrue(result);
    }

    @Test
    public void testProcessCommand_Double() {
        int startNumber= 2;
        int resultNumber = 4;

        when(stackNumbers.getCurrentValue()).thenReturn(startNumber);

        boolean result = calculatorController.processCommand("double");

        verify(stackNumbers).getCurrentValue();
        verify(printer).print(resultNumber);
        verify(stackNumbers).saveValue(resultNumber);
        assertTrue(result);
    }

    @Test
    public void testProcessCommand_RandomNumber() {
        int number = 5;

        when(stackNumbers.getCurrentValue()).thenReturn(number);

        boolean result = calculatorController.processCommand("randadd");

        verify(stackNumbers).getCurrentValue();
        verify(printer).print(anyInt());
        verify(stackNumbers).saveValue(anyInt());
        assertTrue(result);
    }

    @Test
    public void testProcessCommand_Undo_Success() {
        int prevNumber = 4;
        int curNumber = 5;

        when(stackNumbers.getCurrentValue()).thenReturn(curNumber);
        when(undo.undo(stackNumbers)).thenReturn(prevNumber);

        boolean result = calculatorController.processCommand("undo");

        verify(stackNumbers).getCurrentValue();
        verify(printer).print(anyInt());
        assertTrue(result);
    }

    @Test
    public void testProcessCommand_Undo_EmptyStack() {
        when(undo.undo(stackNumbers)).thenThrow(new EmptyStackException());

        boolean result = calculatorController.processCommand("undo");

        assertTrue(result);
    }

    @Test
    public void testProcessCommand_Stop() {
        boolean result = calculatorController.processCommand("stop");

        assertFalse(result);
        verifyNoInteractions(printer);
    }

    @Test
    public void testProcessCommand_UnknownCommand() {
        boolean result = calculatorController.processCommand("unknown");

        verify(printer).print("Unknown command!");
        assertTrue(result);
    }


}