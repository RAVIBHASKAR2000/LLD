

public class WithdrawState implements ATMState {
    ATM atm;
    public WithdrawState(ATM atm) { this.atm = atm; }
    public void withdrawCash(long amount) {
        if (atm.account.isSufficientBalance(amount)) {
            atm.dispenseCash(amount);
            atm.account.debitAmount(amount);
        }
    }
    public void insertCard(Card card) {}
    public void removeCard() {}
    public void selectOperation(TransactionType type) {}
    public void checkBalance() {}
}