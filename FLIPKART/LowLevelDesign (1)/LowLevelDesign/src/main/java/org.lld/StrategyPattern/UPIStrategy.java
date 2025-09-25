package main.java.org.lld.StrategyPattern;

public class UPIStrategy implements PaymentStrategyInterface{
    @Override
    public void processPayment(float amount) {
        System.out.printf("Payment of %s amount processed from UPI!\n",amount);
    }
}
