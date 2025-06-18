class CardInsertedState implements ATMState {
    ATM atm;
    public CardInsertedState(ATM atm) { this.atm = atm; }
    public void selectOperation(TransactionType type) {
        if (type == TransactionType.CHECK_BALANCE) {
            atm.setCurrentState(new CheckBalanceState(atm));
        } else {
            atm.setCurrentState(new WithdrawState(atm));
        }
    }
    public void insertCard(Card card) {}
    public void removeCard() {}
    public void checkBalance() {}
    public void withdrawCash(long amount) {}
}
