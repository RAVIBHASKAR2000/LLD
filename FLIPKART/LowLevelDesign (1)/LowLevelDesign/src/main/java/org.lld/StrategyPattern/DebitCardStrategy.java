package main.java.org.lld.StrategyPattern;

public class DebitCardStrategy implements PaymentStrategyInterface{
    @Override
    public void processPayment(float amount) {
        System.out.printf("Payment of %s amount processed from Debit Card!\n",amount);
    }
}
