

package TicTacToe;
import  java.util.*;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Alice", 'X');
        Player player2 = new Player("Bob", 'O');

        List<ValidateStrategy> validators = List.of(new RowValidator(), new ColValidator(), new OccupancyValidator());
        CompositeValidator validator = new CompositeValidator(validators);

        GameStrategy winStrategy = new Win();
        GameStrategy drawStrategy = new Draw();
        Board board = new Board(3, winStrategy, drawStrategy, validator);
        ConsoleRenderer renderer = new ConsoleRenderer();

        GameController controller = GameController.getInstance(player1, player2, board, renderer);
        controller.startGame();
    }
}
