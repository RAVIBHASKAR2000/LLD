
import  java.util.*;

class Expense {
    private final String description;
    private final User paidBy;
    private final double amount;
    private final List<Split> splits;

    public Expense(String description, double amount, User paidBy, List<Split> splits) {
        this.description = description;
        this.paidBy = paidBy;
        this.amount = amount;
        this.splits = splits;
    }

    public User getPaidBy() { return paidBy; }
    public double getAmount() { return amount; }
    public List<Split> getSplits() { return splits; }
}