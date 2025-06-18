

public class IdleState implements ATMState {
    ATM atm;
    public IdleState(ATM atm) {
        this.atm = atm;
    }

    public void insertCard(Card card) {
        atm.insertedCard = card;
        atm.setCurrentState(new CardInsertedState(atm));
    }
    public void removeCard() {}
    public void selectOperation(TransactionType type) {}
    public void checkBalance() {}
    public void withdrawCash(long amount) {}
}