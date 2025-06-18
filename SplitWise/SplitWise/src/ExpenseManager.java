
import  java.util.*;
class ExpenseManager {
    private static ExpenseManager instance;
    private final Map<String, User> users;
    private final Map<String, Map<String, Double>> balanceSheet;

    private ExpenseManager() {
        users = new HashMap<>();
        balanceSheet = new HashMap<>();
    }

    public static ExpenseManager getInstance() {
        if (instance == null) {
            instance = new ExpenseManager();
        }
        return instance;
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
        balanceSheet.put(user.getId(), new HashMap<>());
    }

    public void addExpense(String description, double amount, User paidBy, List<Split> splits, SplitType type) {
        SplitStrategy strategy = SplitStrategyFactory.getStrategy(type);
        strategy.calculate(splits, amount);
        strategy.validate(splits, amount);

        Expense expense = new Expense(description, amount, paidBy, splits);
        for (Split split : expense.getSplits()) {
            if (split.getUser().getId().equals(paidBy.getId())) continue;

            balanceSheet.get(split.getUser().getId())
                    .put(paidBy.getId(), balanceSheet.get(split.getUser().getId())
                            .getOrDefault(paidBy.getId(), 0.0) + split.getAmount());

            balanceSheet.get(paidBy.getId())
                    .put(split.getUser().getId(), balanceSheet.get(paidBy.getId())
                            .getOrDefault(split.getUser().getId(), 0.0) - split.getAmount());
        }
    }


    public void simplifyDebts() {
        Map<String, Double> netBalance = new HashMap<>();

        // Step 1: Build net balances
        for (String user1 : balanceSheet.keySet()) {
            for (Map.Entry<String, Double> entry : balanceSheet.get(user1).entrySet()) {
                String user2 = entry.getKey();
                double amount = entry.getValue();

                netBalance.put(user1, netBalance.getOrDefault(user1, 0.0) + amount);
                netBalance.put(user2, netBalance.getOrDefault(user2, 0.0) - amount);
            }
        }

        // Step 2: Use two priority queues for +ve and -ve balances
        PriorityQueue<Map.Entry<String, Double>> creditors = new PriorityQueue<>((a, b) -> Double.compare(b.getValue(), a.getValue()));
        PriorityQueue<Map.Entry<String, Double>> debtors = new PriorityQueue<>((a, b) -> Double.compare(a.getValue(), b.getValue()));

        for (Map.Entry<String, Double> entry : netBalance.entrySet()) {
            if (entry.getValue() > 0) creditors.offer(entry);
            else if (entry.getValue() < 0) debtors.offer(entry);
        }

        // Step 3: Settle debts
        while (!creditors.isEmpty() && !debtors.isEmpty()) {
            var creditor = creditors.poll();
            var debtor = debtors.poll();

            double min = Math.min(creditor.getValue(), -debtor.getValue());

            System.out.println(users.get(debtor.getKey()).getName() + " pays " + users.get(creditor.getKey()).getName() + ": " + min);

            double remainingCreditor = creditor.getValue() - min;
            double remainingDebtor = debtor.getValue() + min;

            if (Math.abs(remainingCreditor) > 0.01)
                creditors.offer(Map.entry(creditor.getKey(), remainingCreditor));
            if (Math.abs(remainingDebtor) > 0.01)
                debtors.offer(Map.entry(debtor.getKey(), remainingDebtor));
        }
    }
    public void showBalances() {
        for (String user1 : balanceSheet.keySet()) {
            for (String user2 : balanceSheet.get(user1).keySet()) {
                double amount = balanceSheet.get(user1).get(user2);
                if (amount > 0) {
                    System.out.println(users.get(user1).getName() + " owes " + users.get(user2).getName() + ": " + amount);
                }
            }
        }
    }
}