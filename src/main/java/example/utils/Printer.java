package example.utils;

public class Printer {
    public Printer() {
    }

    public void print(int number){
        System.out.println(number);
    }

    public void print(String msg){
        System.out.println(msg);
    }

    public void printCommand() {
        print("Commands:");
        print("increment - increases result value by 1");
        print("decrement - decreases result value by 1");
        print("double - doubles the result value");
        print("randadd - changes result by random number");
        print("undo - reverts the most recent command that is not an undo and was not yet undone");
        print("stop - shutting down the calculator");
    }
}
