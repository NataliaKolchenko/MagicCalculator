package example.repository;

import java.util.Stack;

public class History {
    private final Stack<Integer> numbers = new Stack<>();

    public int undo() {
        numbers.pop();
        return numbers.peek();
    }

    public int getCurrentValue() {
        if (numbers.isEmpty()){
            return 0;
        } else {
            return numbers.peek();
        }
    }

    public void saveValue(int value) {
        numbers.push(value);
    }
}
