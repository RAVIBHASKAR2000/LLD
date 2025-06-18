
import java.util.*;

import  java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Account account = AccountFactory.create(AccountType.SAVINGS);
        account.id = "acc123";
        account.accountHolder = "John Doe";
        account.accountNumber = "1234567890";
        account.totalBalance = 5000;
        account.availableBalance = 5000;

        Card card = new Card();
        card.id = "card123";
        card.accountId = account.id;
        card.cardNumber = "1111-2222-3333-4444";
        card.pin = "1234"; // In real systems, this would be encrypted
        card.expiryDate = LocalDate.of(2030, 12, 31);

        ATM atm = new ATM();
        atm.account = account;  // Inject account associated with card

        // Insert card into ATM
        System.out.println("Inserting card...");
        atm.currentATMState.insertCard(card);

        // Authenticate user
        System.out.println("Authenticating user...");
        atm.authenticateUser(card.cardNumber, "1234");

        // Select balance inquiry operation
        System.out.println("Selecting operation: CHECK_BALANCE");
        atm.currentATMState.selectOperation(TransactionType.CHECK_BALANCE);
        atm.currentATMState.checkBalance();

        // Select withdraw operation
        System.out.println("\nSelecting operation: CASH_WITHDRAWAL");
        atm.currentATMState.selectOperation(TransactionType.CASH_WITHDRAWAL);
        atm.currentATMState.withdrawCash(1300);  // Withdraw 1300

        // Check balance again
        System.out.println("\nRe-checking balance:");
        atm.setCurrentState(new CheckBalanceState(atm));
        atm.currentATMState.checkBalance();
    }
}