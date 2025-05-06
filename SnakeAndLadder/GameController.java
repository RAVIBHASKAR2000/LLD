package SnakeAndLadder;

import java.util.List;
import java.util.Scanner;

public class GameController {
    public Board board;
    public List<Player> players;
    public  Player currentPlayer;
    public  int currentPlayerIndex ;
    public  Display display;

    public  Dice dice;
    public  GameController(Board board, List<Player> players, Display display){
            this.board = board;
            this.players = players;
            this.display = display;
            this.currentPlayerIndex = 0;
            this.dice = new Dice();

    }

    public  Player getCurrentPlayer(){
       return this.players.get(currentPlayerIndex);
    }
//    public void addPlayer(Player p){
//        this.players.add(p);
//    }

    public  void  startGame(){
        while(true){
            this.display.displayPlayers(players);
            Player player = getCurrentPlayer();
            System.out.println("Players - " + player.getPlayerName() + " turn");
            System.out.println("already at "+ player.getPosition());
            System.out.println("press 1 to roll dice");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();

            int dice_occ =dice.roll();

            System.out.println("Dice :" + dice_occ);


            int tentativePos = player.getPosition() + dice_occ;
            if (tentativePos > board.getSize()) {
                System.out.println("Move exceeds board size. You stay at the same position.");
                changePlayer();
                continue;
            } else {


                int new_posi = board.verify(player.getPosition() + dice_occ);

                if (board.checkWin(new_posi)) {
                    System.out.println("Player " + player.getPlayerName() + " WINS!");
                    return;
                }

                player.setPosition(new_posi);

                System.out.println("Reached " + player.getPosition());

            }

            changePlayer();
        }
    }

    public  void changePlayer(){
        currentPlayerIndex = (currentPlayerIndex +1 )% players.size();
    }

}
