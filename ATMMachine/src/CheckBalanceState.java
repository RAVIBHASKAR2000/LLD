class CheckBalanceState implements ATMState {
    ATM atm;
    public CheckBalanceState(ATM atm) { this.atm = atm; }
    public void checkBalance() {
        System.out.println("Available Balance: " + atm.account.getAvailableBalance());
    }
    public void insertCard(Card card) {}
    public void removeCard() {}
    public void selectOperation(TransactionType type) {}
    public void withdrawCash(long amount) {}
}
