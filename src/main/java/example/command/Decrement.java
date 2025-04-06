package example.command;


import static example.config.Config.DECREMENT_NUMBER;

public class Decrement {

    public int decrement(int lastNumber){
        return lastNumber - DECREMENT_NUMBER;
    }
}
