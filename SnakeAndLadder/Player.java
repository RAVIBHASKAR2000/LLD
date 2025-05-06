package SnakeAndLadder;

public class Player implements PlayerInterface {
    public  String Playername;
    public int position;
    public String colour;


    public  Player(String playername, String colour){
        this.Playername = playername;
        this.position = 0;
        this.colour = colour;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String getPlayerName() {
        return this.Playername;
    }

    public String getColour() {
        return colour;
    }
}
