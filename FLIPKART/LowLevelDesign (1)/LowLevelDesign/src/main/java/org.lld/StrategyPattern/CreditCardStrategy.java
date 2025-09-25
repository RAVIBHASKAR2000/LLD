package main.java.org.lld.StrategyPattern;

public class CreditCardStrategy implements PaymentStrategyInterface{

    @Override
    public void processPayment(float amount) {
        System.out.printf("Payment of %s amount processed from credit Card!\n",amount);
    }
}
