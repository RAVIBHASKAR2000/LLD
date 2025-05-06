package TicTacToe;

import java.util.Scanner;

public class GameController {

    //singleton class

    private static GameController instance;
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final ConsoleRenderer renderer;

    private GameController(Player player1, Player player2, Board board, ConsoleRenderer renderer) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.renderer = renderer;
        this.currentPlayer = player1;
    }

    public static GameController getInstance(Player player1, Player player2, Board board, ConsoleRenderer renderer) {
        if (instance == null) {
            instance = new GameController(player1, player2, board, renderer);
        }
        return instance;
    }

    public void changePlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public void startGame() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            renderer.drawBoard(board.getBoard());
            System.out.println("Player turn: " + currentPlayer.getName());
            System.out.print("row: ");
            int x = sc.nextInt();
            System.out.print("col: ");
            int y = sc.nextInt();

            if (!board.assignSymbol(x, y, currentPlayer)) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            if (board.checkWin(currentPlayer)) {
                renderer.drawBoard(board.getBoard());
                System.out.println("Player " + currentPlayer.getName() + " wins!");
                return;
            }

            if (board.checkDraw(currentPlayer)) {
                renderer.drawBoard(board.getBoard());
                System.out.println("It's a draw!");
                return;
            }

            changePlayer();
        }
    }

}
