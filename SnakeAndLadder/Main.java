package SnakeAndLadder;

import java.util.*;

public class Main {

    public  static void main(String[] args){
        Map<Integer, Snake> snakes = new HashMap<>();
        List<int[]> snake_array = Arrays.asList(new int[][]{{16, 6}, {48, 26}, {49, 11}});


        Map<Integer, Ladder> ladders = new HashMap<>();
        List<int[]> ladder_array = Arrays.asList(new int[][]{{5, 17}, {18, 56}, {29, 41}});

        ObstaclesFactory obstaclesFactory = new ObstaclesFactory();
        obstaclesFactory.createSnakes(snake_array, snakes);
        obstaclesFactory.createLadders(ladder_array, ladders);

        Board board = Board.getInstance(snakes, ladders,100);
        List<Player> players = new ArrayList<>();

        Player player1 = new Player("Ravi" , "Red");
        Player player2 = new Player("Bhaskar", "Blue");

        players.add(player1);
        players.add(player2);
        GameController gameController = new GameController(board, players, new Display());


        gameController.startGame();
    }
}
