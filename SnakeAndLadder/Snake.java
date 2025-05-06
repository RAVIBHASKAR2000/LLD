package SnakeAndLadder;

public class Snake implements  Obstacles {
    int start;
    int end;

    public  Snake(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    public int move() {
        return this.end;
    }
}