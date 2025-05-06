package TicTacToe;



class OccupancyValidator implements ValidateStrategy {
    public boolean validate(int x, int y, Player player, Character[][] board) {
        return board[x][y] == null;
    }
}