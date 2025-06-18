public class TwoHundredDispenser extends CashDispenser {
    public void dispense(int amount) {
        if (amount >= 200) {
            int notes = amount / 200;
            int remainder = amount % 200;
            System.out.println("Dispensed " + notes + " x 200");
            if (remainder > 0 && next != null) next.dispense(remainder);
        } else if (next != null) {
            next.dispense(amount);
        }
    }
}