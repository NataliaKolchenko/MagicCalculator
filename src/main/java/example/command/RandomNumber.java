package example.command;

public class RandomNumber {

    public int randadd(int lastNumber){
        int randomNumber = (int) (Math.random() * 201) - 100; // from -100 to 100
        return lastNumber + randomNumber;
    }
}
