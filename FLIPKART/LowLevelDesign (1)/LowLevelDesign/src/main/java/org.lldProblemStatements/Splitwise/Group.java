package main.java.org.lldProblemStatements.Splitwise;

import java.util.*;

public class Group {
    private List<Expense> expenseList;
    private List<User> users;
    private User createdBy;
    private String groupName;
    private HashMap<User, Double> balances;

    public Group(String groupName,List<User> users, User createdBy){
        this.createdBy = createdBy;
        this.groupName = groupName;
        this.users = new ArrayList<>();
        this.expenseList = new ArrayList<>();
        this.users.addAll(users);
        this.users.add(createdBy);
        this.balances = new HashMap<>();
        for(User user:this.users){
            balances.put(user,0d);
        }
    }

    private void updateBalances(Expense expense){
        HashMap<User,Double> currBalance = expense.getSplit();
        for(Map.Entry<User,Double> mp: currBalance.entrySet()){
            this.balances.put(mp.getKey(),this.balances.get(mp.getKey())+mp.getValue());
        }
    }

    public void getBalanceOfUser(User user){
        System.out.println("You owe " +this.balances.get(user)+ " rupees in the group "+this.groupName);
    }

    public void addUser(User user){
        users.add(user);
        user.addToGroup(this);
    }

    public void removeUser(User user){
        users.remove(user);
        user.removeFromGroup(this);
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public String getGroupName() {
        return groupName;
    }

    public void addExpense(Expense expense){
        expenseList.add(expense);
        updateBalances(expense);
    }

    public void deleteExpense(Expense expense){
        expenseList.remove(expense);
    }

    public void editExpense(Expense expense, Expense updatedExpense){
        // edit the expense
        updateBalances(expense);
    }
}
