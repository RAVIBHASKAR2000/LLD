
import  java.util.*;

class ExactSplitStrategy implements SplitStrategy {
    public void validate(List<Split> splits, double totalAmount) {
        double sum = 0;
        for (Split split : splits) {
            sum += split.getAmount();
        }
        if (Math.abs(sum - totalAmount) > 0.01) {
            throw new RuntimeException("Exact amounts do not sum to total");
        }
    }

    public void calculate(List<Split> splits, double totalAmount) {
        // Already provided
    }
}
