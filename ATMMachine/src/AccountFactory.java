

public class AccountFactory {
    public static Account create(AccountType type) {
        switch(type) {
            case CURRENT: return new CurrentAccount();
            case SAVINGS: return new SavingsAccount();
            default: throw new IllegalArgumentException("Unknown type");
        }
    }
}
