class FiveHundredDispenser extends CashDispenser {
    public void dispense(int amount) {
        if (amount >= 500) {
            int notes = amount / 500;
            int remainder = amount % 500;
            System.out.println("Dispensed " + notes + " x 500");
            if (remainder > 0 && next != null) next.dispense(remainder);
        } else if (next != null) {
            next.dispense(amount);
        }
    }
}
