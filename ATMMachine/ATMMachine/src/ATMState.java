public  interface ATMState {
    void insertCard(Card card);
    void removeCard();
    void selectOperation(TransactionType type);
    void checkBalance();
    void withdrawCash(long amount);
}
