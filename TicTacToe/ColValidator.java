package TicTacToe;

class ColValidator implements ValidateStrategy {
    public boolean validate(int x, int y, Player player, Character[][] board) {
        return y >= 0 && y < board.length;
    }
}