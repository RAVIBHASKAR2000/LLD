package SnakeAndLadder;

import java.util.Map;

public class Validator {
    public Validator(){

    }

    public  Obstacles verify(Map<Integer, Snake> snakes, Map<Integer, Ladder> ladders, int posi){
        if(snakes.containsKey(posi)){
            return snakes.get(posi);
        }
        if(ladders.containsKey(posi)){
            return  ladders.get(posi);
        }
        return  null;
    }

}
