package TicTacToe;

public class Player implements  PlayerInterface{
    private String playerName;
    public  char symbol;

    Player(String name , char symbol){
        this.playerName = name;
        this.symbol = symbol;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String getName() {
        return this.playerName;
    }

    @Override
    public char getSymbol() {
        return this.symbol;
    }
}
