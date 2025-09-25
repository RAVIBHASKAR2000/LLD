package main.java.org.lldProblemStatements.Splitwise;

import java.util.*;

public class Client {
    public static void main(String[] args){
        SplitWise splitWise = SplitWise.getInstance();
        User u1 = new User("akshay");
        User u2 = new User("krishika");
        User u3 = new User("sheetal");
        User u4 = new User("ram");

        splitWise.addUser(u1);
        splitWise.addUser(u2);
        splitWise.addUser(u3);

        List<User> users = new ArrayList<>();
        users.add(u1);
        users.add(u2);
        users.add(u3);

        Group testGroup = splitWise.createGroup("Test-Group",users,u1);
        testGroup.addUser(u4);

        Expense groceriesExpense = new Expense("123",123.4546,u1,new EqualSplitStrategy(), users);

        testGroup.addExpense(groceriesExpense);
        testGroup.getBalanceOfUser(u2);
    }
}
