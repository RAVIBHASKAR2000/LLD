public abstract class Account {
    String id;
    String accountHolder;
    String accountNumber;
    long totalBalance;
    long availableBalance;

    public void debitAmount(long amount) {
        if (isSufficientBalance(amount)) {
            this.availableBalance = this.availableBalance - amount;
        }
    }

    public void creditAmount(long amount) {
        this.availableBalance = this.availableBalance + amount;
    }

    public long getAvailableBalance() {
        return this.availableBalance;
    }

    public boolean isSufficientBalance(long amount) {
        return this.availableBalance > amount;
    }
}