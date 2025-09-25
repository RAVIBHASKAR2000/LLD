package main.java.org.lldProblemStatements.Splitwise;

import java.util.*;

public class Expense {
    private final String expenseID;
    private double amount;
    private User paidBy;
    private HashMap<User,Double> split;
    private SplitStrategy strategy;

    public Expense(String expenseID, double amount, User paidBy, SplitStrategy strategy, List<User> userList) {
        this.expenseID = expenseID;
        this.amount = amount;
        this.paidBy = paidBy;
        this.strategy = strategy;
        this.split = new HashMap<>();
        this.split(userList);
    }

    public String getExpenseID() {
        return expenseID;
    }

    private void split(List<User> splitAmong){
        this.split.putAll(this.strategy.calculateSplit(amount, splitAmong));
        double val = this.split.get(this.paidBy);
        this.split.put(this.paidBy,val-this.amount);
    }

    public double getAmount() {
        return amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public HashMap<User, Double> getSplit() {
        return split;
    }
}
