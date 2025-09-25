package main.java.org.lld.StrategyPattern;

import java.util.ArrayList;
import java.util.*;

public class PaymentGateway{

    private HashMap<String,PaymentStrategyInterface> paymentStrategies;

    public PaymentGateway(){
        paymentStrategies = new HashMap<String,PaymentStrategyInterface>();
    }

    public void addPaymentMethod(PaymentStrategyInterface p, String name) {
        this.paymentStrategies.put(name,p);
    }

    public void removePaymentMethod(PaymentStrategyInterface p,String name) {
        this.paymentStrategies.remove(name);
    }

    public void pay(String name, float amount) {
        // TODO add a check for if payment method is not found :(
        paymentStrategies.get(name).processPayment(amount);
    }
}
