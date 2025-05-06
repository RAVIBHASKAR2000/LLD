package TicTacToe;

public class Win implements  GameStrategy {
    @Override
    public boolean check(Character[][] board, char symbol) {

            // Rows & Columns
        try {
            for (int i = 0; i < board.length; i++) {
                if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol)
                    return true;
                if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)
                    return true;
            }
            // Diagonals
            if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
                return true;
            if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)
                return true;

            return false;
        } catch (NullPointerException e) {
            return  false;
        }


    }
}
