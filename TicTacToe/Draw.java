package TicTacToe;

public class Draw implements GameStrategy{
    @Override
    public boolean check(Character[][] board, char symbol) {
        for (Character[] row : board)
            for (Character cell : row)
                if (cell == null)
                    return false;
        return true;

    }
}
