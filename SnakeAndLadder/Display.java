package SnakeAndLadder;

import java.util.List;

public class Display {

    public  Display(){

    }

    void displayPlayers(List<Player> players){
        for(Player p: players){
            System.out.println("Player - " + p.getPlayerName() +" posi- " + p.getPosition() + " colour -" + p.getColour());
        }
    }
}
