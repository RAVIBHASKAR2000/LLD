package TicTacToe;

class RowValidator implements ValidateStrategy {
    public boolean validate(int x, int y, Player player, Character[][] board) {
        return x >= 0 && x < board.length;
    }
}