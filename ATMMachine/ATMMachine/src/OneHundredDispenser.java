
public class OneHundredDispenser extends CashDispenser {
    public void dispense(int amount) {
        if (amount >= 100) {
            int notes = amount / 100;
            int remainder = amount % 100;
            System.out.println("Dispensed " + notes + " x 100");
            if (remainder > 0 && next != null) next.dispense(remainder);
        } else if (next != null) {
            next.dispense(amount);
        }
    }
}
