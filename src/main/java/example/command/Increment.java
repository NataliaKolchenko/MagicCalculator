package example.command;

import static example.config.Config.INCREMENT_NUMBER;

public class Increment {

    public int increment (int lastNumber){
        return lastNumber + INCREMENT_NUMBER;
    }
}
