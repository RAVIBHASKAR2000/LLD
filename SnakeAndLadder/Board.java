package SnakeAndLadder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private static Board board;
    Map< Integer, Snake>  snakes;
    Map<Integer, Ladder> ladders;

    int size;

    public  Validator validator ;
    private  Board(Map<Integer, Snake> snakes, Map<Integer, Ladder> ladders, int size){
        this.snakes = snakes;
        this.ladders = ladders;
        this.validator = new Validator();
        this.size =size;
    }

    public static Board getInstance(Map<Integer, Snake> snakes, Map<Integer, Ladder> ladders, int size){
        if(board ==null){
            board = new Board(snakes, ladders, size);
            return board;
        }
        return board;
    }


    public int verify(int posi){

        Obstacles ob= validator.verify(snakes, ladders, posi);
        if(ob !=null) {
            return ob.move();
        }
        return posi;
    }

    public  boolean checkWin(int posi){
        if(posi >= this.size){
            return  true;
        }
        return  false;
    }

    public int getSize() {
        return size;
    }
}
