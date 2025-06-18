import  java.util.*;

public class Main {
    public static void main(String[] args) {
        {
            ExpenseManager manager = ExpenseManager.getInstance();

            User u1 = new User("u1", "Alice");
            User u2 = new User("u2", "Bob");
            User u3 = new User("u3", "Charlie");

            manager.addUser(u1);
            manager.addUser(u2);
            manager.addUser(u3);

            List<Split> splits1 = List.of(new Split(u1), new Split(u2), new Split(u3));
            manager.addExpense("Lunch", 300, u1, splits1, SplitType.EQUAL);

            Split s1 = new Split(u2);
            s1.setAmount(70);
            Split s2 = new Split(u3);
            s2.setAmount(30);
            List<Split> splits2 = List.of(s1, s2);
            manager.addExpense("Taxi", 100, u1, splits2, SplitType.EXACT);

            manager.simplifyDebts();
            manager.showBalances();

        }

    }
}