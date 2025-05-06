package TicTacToe;
import java.util.*;


public class CompositeValidator {
    private final List<ValidateStrategy> strategies;

    public CompositeValidator(List<ValidateStrategy> strategies) {
        this.strategies = strategies;
    }

    public boolean validate(int x, int y, Player player, Character[][] board) {
        for (ValidateStrategy strategy : strategies) {
            if (!strategy.validate(x, y, player, board)) {
                return false;
            }
        }
        return true;
    }
}
