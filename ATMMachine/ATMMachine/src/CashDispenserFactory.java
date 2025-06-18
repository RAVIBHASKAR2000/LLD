class CashDispenserFactory {
    public static CashDispenser getDispenserChain() {
        CashDispenser fiveHundred = new FiveHundredDispenser();
        CashDispenser twoHundred = new TwoHundredDispenser();
        CashDispenser oneHundred = new OneHundredDispenser();

        fiveHundred.setNext(twoHundred);
        twoHundred.setNext(oneHundred);

        return fiveHundred;
    }
}
