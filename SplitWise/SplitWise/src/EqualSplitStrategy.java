

import java.util.*;

class EqualSplitStrategy implements SplitStrategy {
    public void validate(List<Split> splits, double totalAmount) {
        // Always valid
    }

    public void calculate(List<Split> splits, double totalAmount) {
        double equalAmount = totalAmount / splits.size();
        for (Split split : splits) {
            split.setAmount(equalAmount);
        }
    }
}