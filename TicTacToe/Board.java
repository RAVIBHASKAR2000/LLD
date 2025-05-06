package TicTacToe;

public class Board {

    private final Character[][] board;
    private final GameStrategy winStrategy;
    private final GameStrategy drawStrategy;
    private final CompositeValidator validator;

    public Board(int size, GameStrategy winStrategy, GameStrategy drawStrategy, CompositeValidator validator) {
        this.board = new Character[size][size];
        this.winStrategy = winStrategy;
        this.drawStrategy = drawStrategy;
        this.validator = validator;
    }

    public Character[][] getBoard() {
        return board;
    }

    public boolean assignSymbol(int x, int y, Player player) {
        if (validator.validate(x, y, player, board)) {
            board[x][y] = player.getSymbol();
            return true;
        }
        return false;
    }

    public boolean checkWin(Player player) {
        return winStrategy.check(board, player.getSymbol());
    }

    public boolean checkDraw(Player player) {
        return drawStrategy.check(board, player.getSymbol());
    }



}
