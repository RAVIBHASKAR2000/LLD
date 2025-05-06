package TicTacToe;

public class ConsoleRenderer {
    public void drawBoard(Character[][] board) {
        for (Character[] row : board) {
            for (Character cell : row) {
                System.out.print((cell != null ? cell : '_') + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
