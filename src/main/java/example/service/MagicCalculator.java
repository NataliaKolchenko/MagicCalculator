package example.service;

import example.controller.CalculatorController;
import example.utils.Printer;

import java.util.Scanner;

public class MagicCalculator {
    private final Scanner scanner = new Scanner(System.in);
    private final Printer printer = new Printer();
    private final CalculatorController controller = new CalculatorController();

    public void run() {
        boolean running = true;

        controller.getStartNumber();
        printer.printCommand();

        while (running) {
            printer.print("Enter command: ");
            String command = scanner.nextLine().toLowerCase().trim();

            running = controller.processCommand(command);
        }

    }

}





