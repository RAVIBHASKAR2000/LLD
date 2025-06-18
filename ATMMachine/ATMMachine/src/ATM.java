
import java.util.*;

public class ATM {
    long availableBalance;
    Map<Note, Integer> notesCountMap;
    ATMState currentATMState;
    Card insertedCard;
    Account account;
    CashDispenser dispenser;

    public ATM() {
        this.notesCountMap = new HashMap<>();
        this.availableBalance = 0;
        this.dispenser = CashDispenserFactory.getDispenserChain();
        this.currentATMState = new IdleState(this);
    }

    public void authenticateUser(String cardNumber, String pin) {
        // load card and validate
        if (insertedCard.validateCard(pin) && !insertedCard.isExpired()) {
            setCurrentState(new CardInsertedState(this));
        }
    }

    public void setCurrentState(ATMState state) {
        this.currentATMState = state;
    }

    public void dispenseCash(long amount) {
        this.dispenser.dispense((int)amount);
        updateATMBalance(amount * -1);
    }

    public void updateATMBalance(long amount) {
        this.availableBalance = this.availableBalance + amount;
    }
}