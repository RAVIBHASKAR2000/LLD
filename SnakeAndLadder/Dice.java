package SnakeAndLadder;

public class Dice implements  DiceInterface {
    @Override
    public int roll() {
        return (int)(Math.random() * 6) + 1;
    }
}
