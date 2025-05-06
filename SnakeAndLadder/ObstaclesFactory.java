package SnakeAndLadder;

import java.util.Map;
import java.util.List;

public class ObstaclesFactory {
    public ObstaclesFactory(){

    }

    public  void createSnakes(List<int[]> snakes, Map<Integer, Snake> snakesMap) {
        for (int[] snake : snakes) {
            snakesMap.put( snake[0], new Snake(snake[0], snake[1]));
        }
    }

    public  void createLadders(List<int[]> ladders, Map<Integer, Ladder> LadderMap) {
        for (int[] ladder : ladders) {
            LadderMap.put( ladder[0], new Ladder(ladder[0], ladder[1]));
        }
    }

}

