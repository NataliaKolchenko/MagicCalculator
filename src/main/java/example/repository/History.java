package example.repository;

import java.util.Stack;

public class History {
    private final Stack<Integer> numbers = new Stack<>();
    private final Stack<String> commands = new Stack<>();

    public void save(int valueBeforeCommand, String commandName) {
        if (!commandName.equals("undo")) {
            numbers.push(valueBeforeCommand);
            commands.push(commandName);
        }
    }

    public boolean undo() {
        if (!commands.isEmpty()) {
            String lastCommand = commands.pop();
            numbers.pop();
            return !lastCommand.equals("undo");
        }
        return false;
    }

    public int getCurrentValue() {
        if (numbers.isEmpty()){
            return 0;
        } else {
            return numbers.peek();
        }
    }

    public Stack<Integer> getNumbers() {
        return numbers;
    }
}
