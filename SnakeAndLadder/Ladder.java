package SnakeAndLadder;

public class Ladder implements  Obstacles{
    int start;
    int end;

    public Ladder(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    public int move() {
        return this.end;
    }
}
