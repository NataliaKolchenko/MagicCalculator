package example.controller;

import example.command.*;
import example.command.DoubleNumber;
import example.repository.History;
import example.utils.Printer;

import java.util.EmptyStackException;
import java.util.Scanner;

public class CalculatorController {
    private final Printer printer;
    private final Scanner scanner;
    private final History stackNumbers;

    public CalculatorController() {
        this.printer = new Printer();
        this.scanner = new Scanner(System.in);
        this.stackNumbers = new History();
    }

    public CalculatorController(Printer printer, Scanner scanner, History stackNumbers) {
        this.printer = printer;
        this.scanner = scanner;
        this.stackNumbers = stackNumbers;
    }

    public void getStartNumber() {
        int startNumber;
        boolean validInput = false;

        while (!validInput) {
            printer.print("Write start number: ");
            String input = scanner.nextLine();
            try {
                startNumber = Integer.parseInt(input.trim());
                stackNumbers.saveValue(startNumber);
                validInput = true;
            } catch (NumberFormatException e) {
                printer.print("Invalid input! Please enter a valid number.");
            }
        }

    }

    public boolean processCommand(String command) {
        int result = stackNumbers.getCurrentValue();
        switch (command) {
            case "increment":
                Increment inc = new Increment();
                result = inc.increment(result);
                stackNumbers.saveValue(result);
                printer.print(result);
                break;

            case "decrement":
                Decrement dec = new Decrement();
                result = dec.decrement(result);
                stackNumbers.saveValue(result);
                printer.print(result);
                break;

            case "double":
                DoubleNumber dNum = new DoubleNumber();
                result = dNum.doubleNumber(result);
                stackNumbers.saveValue(result);
                printer.print(result);
                break;

            // randadd adds a random integer from -100 to +100 to the current result
            case "randadd":
                RandomNumber rand = new RandomNumber();
                result = rand.randadd(result);
                stackNumbers.saveValue(result);
                printer.print(result);
                break;

            case "undo":
                Undo undo = new Undo();
                try {
                    printer.print(undo.undo(stackNumbers));
                } catch (EmptyStackException e) {
                    printer.print("No actions to undo.");
                }
                break;

            case "stop":
                return false;
            default:
                printer.print("Unknown command!");
                break;
        }
        return true;
    }
}
